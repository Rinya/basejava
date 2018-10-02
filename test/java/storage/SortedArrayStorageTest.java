package storage;

import model.Resume;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class SortedArrayStorageTest {
    private SortedArrayStorage arrayStorage;
    private Resume[] original;

    @Before
    public void setUp() {
        original = new Resume[3];
        original[0] = new Resume();
        original[0].setUuid(UUID.randomUUID().toString());
        original[1] = new Resume();
        original[1].setUuid(UUID.randomUUID().toString());
        original[2] = new Resume();
        original[2].setUuid(UUID.randomUUID().toString());

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
    }

    @Test
    public void delete() {
    }

    @Test
    public void getAll() {
    }

    @Test
    public void update() {
    }

    @Test
    public void getIndexOf() {
        arrayStorage.save(original[0]);
        arrayStorage.save(original[1]);
        arrayStorage.save(original[2]);

        int indexOf = arrayStorage.getIndexOf(original[2].getUuid());
        assertEquals(2, indexOf);
    }
}