package ru.javawebinar.basejava.storage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.model.Resume;

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
        arrayStorage.save(original[0]);
        arrayStorage.save(original[1]);
        arrayStorage.save(original[2]);
    }

    @Test
    public void delete() {
    }

    @Test
    public void getAll() {
        /*Integer[] oldArray = new Integer[] { 1, 5, 2, 50 };

        int index = Arrays.binarySearch(oldArray, 3);
        System.out.println("index: " + index);
        if (index < 0) {
            int insertIndex = -index - 1;
            System.out.println("insertIndex: " + insertIndex);

            Integer[] newArray = new Integer[oldArray.length + 1];
            System.arraycopy(oldArray, 0, newArray, 0, insertIndex);
            System.arraycopy(oldArray, insertIndex, newArray, insertIndex + 1,
                    oldArray.length - insertIndex);
            newArray[insertIndex] = 3;
            oldArray = newArray;
        }
        System.out.println(Arrays.toString(oldArray));*/
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