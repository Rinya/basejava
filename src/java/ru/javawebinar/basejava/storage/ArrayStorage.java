package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    @Override
    protected void saveArrayImp(Resume resume, int index) {
        storage[size] = resume;
    }

    @Override
    protected void deleteArrayImp(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    protected Integer getIndexOf(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }

        return -1;
    }
}