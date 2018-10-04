package ru.javawebinar.basejava.storage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortedArrayStorageTest {
    private Storage arrayStorage;
    private Resume[] original;

    @Before
    public void setUp() {
        original = new Resume[6];
        original[0] = new Resume();
        original[0].setUuid(UUID.randomUUID().toString());
        original[1] = new Resume();
        original[1].setUuid(UUID.randomUUID().toString());
        original[2] = new Resume();
        original[2].setUuid(UUID.randomUUID().toString());
        original[3] = new Resume();
        original[3].setUuid(UUID.randomUUID().toString());
        original[4] = new Resume();
        original[4].setUuid(UUID.randomUUID().toString());
        original[5] = new Resume();
        original[5].setUuid(UUID.randomUUID().toString());

        arrayStorage = new SortedArrayStorage();
    }

    @After
    public void tearDown() {
        arrayStorage = null;
    }

    @Test
    public void clear() {
    }

    @Test
    public void save() {
        arrayStorage.save(original[0]);
        arrayStorage.save(original[1]);
        arrayStorage.save(original[2]);
        arrayStorage.save(original[3]);
        arrayStorage.save(original[4]);
        arrayStorage.save(original[5]);

        Resume[] resumes = arrayStorage.getAll();

        assertEquals("В arrayStorage должно быть 6 элементов", 6, arrayStorage.size());
        assertEquals("В массиве должно быть 6 элементов", 6, resumes.length);
    }

    @Test
    public void delete() {
        arrayStorage.save(original[0]);
        arrayStorage.save(original[1]);
        arrayStorage.save(original[2]);
        arrayStorage.save(original[3]);
        arrayStorage.save(original[4]);
        arrayStorage.save(original[5]);

        Resume[] resumes = arrayStorage.getAll();
        assertEquals("В arrayStorage должно быть 6 элементов", 6, arrayStorage.size());
        assertEquals("В массиве должно быть 6 элементов", 6, resumes.length);

        arrayStorage.delete(original[3].getUuid());

        resumes = arrayStorage.getAll();
        assertEquals("В arrayStorage должно быть 5 элементов", 5, arrayStorage.size());
        assertEquals("В массиве должно быть 5 элементов", 5, resumes.length);
    }

    @Test
    public void getAll() {
        arrayStorage.save(original[0]);
        arrayStorage.save(original[1]);
        arrayStorage.save(original[2]);
        arrayStorage.save(original[3]);
        arrayStorage.save(original[4]);
        arrayStorage.save(original[5]);

        Resume[] resumes = arrayStorage.getAll();

        Arrays.sort(original);
        assertEquals("В массиве должно быть 6 элемента", 6, resumes.length);
        assertArrayEquals(original, resumes, "Где-то ошибка, наборы резюме не совпадают");
    }

    @Test
    public void update() {
        arrayStorage.save(original[0]);
        arrayStorage.save(original[1]);
        arrayStorage.save(original[2]);

        assertEquals("В массиве должно быть 3 элемента", 3, arrayStorage.size());

        Resume resume = new Resume();
        resume.setUuid(original[1].getUuid());

        arrayStorage.update(resume);

        assertEquals("Обновление не произошло, разные объекты", resume, arrayStorage.get(resume.getUuid()));
    }

    /*@Test
    public void getIndexOf() {
        arrayStorage.save(original[0]);
        arrayStorage.save(original[1]);
        arrayStorage.save(original[2]);

        int indexOf = arrayStorage.getIndexOf(original[2].getUuid());
        assertFalse("UUID не найден в массиве", indexOf < 0);
    }*/
}