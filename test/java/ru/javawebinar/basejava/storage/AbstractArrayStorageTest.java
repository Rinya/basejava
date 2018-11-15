package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Test;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {
    private static final String VASYA = "vasya";

    AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() {
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_SIZE; i++) {
                storage.save(new Resume(VASYA));
            }
        } catch (StorageException e) {
            Assert.fail();
        }
        storage.save(new Resume(VASYA));
    }
}