package ru.javawebinar.basejava.storage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest {
    private static final String DUMMY = "dummy";
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME_UUID_4 = new Resume(UUID_4);
    private static final String UUID_5 = "uuid5";
    private static final String UUID_6 = "uuid6";
    private static final int HALF_OF_STORAGE = 5000;
    private Storage storage;
    private Resume[] resumeArray;

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();

        resumeArray = new Resume[] {
                new Resume(UUID_1),
                new Resume(UUID_2),
                new Resume(UUID_3),
                RESUME_UUID_4,
                new Resume(UUID_5),
                new Resume(UUID_6)
        };

        storage.save(resumeArray[0]);
        storage.save(resumeArray[1]);
        storage.save(resumeArray[2]);
        storage.save(resumeArray[3]);
        storage.save(resumeArray[4]);
        storage.save(resumeArray[5]);
    }

    @After
    public void tearDown() {
        storage = null;
    }

    @Test
    public void size() {
        assertEquals(6, storage.size());
    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals("The storage should have size 0", 0, storage.size());
    }

    @Test
    public void update() {
        Resume resume = RESUME_UUID_4;
        storage.update(resume);
        assertEquals("Failed to update storage", resume, storage.get(resume.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateToNonExistent() {
        storage.update(new Resume(DUMMY));
    }

    @Test
    public void getAll() {
        Resume[] resumes = storage.getAll();

        assertEquals("Array should have size 6",6, resumes.length);
        assertArrayEquals("Где-то ошибка, наборы резюме не совпадают", resumeArray, resumes);
    }

    @Test
    public void save() {
        Resume resume = new Resume();
        storage.save(resume);

        assertEquals("The storage should have size 7", 7, storage.size());
        assertNotNull("In storage doesn't exist resume with uuid " + resume.getUuid(), storage.get(resume.getUuid()));
    }

    @Test(expected = StorageException.class)
    public void fillingStorage() {
        storage.clear();
        try {
            for (int i = 0; i < HALF_OF_STORAGE; i++) {
                storage.save(new Resume());
                storage.save(new Resume());
            }
        } catch (Exception e) {
            fail("Storage overflow");
        }

        storage.save(new Resume());
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_2);

        assertEquals("The storage should have size 5", 5, storage.size());
        storage.get(UUID_2);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNonExistent() {
        storage.delete(DUMMY);
    }

    @Test
    public void get() {
        assertNotNull("In storage doesn't exist resume with uuid " + UUID_5, storage.get(UUID_5));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get(DUMMY);
    }
}