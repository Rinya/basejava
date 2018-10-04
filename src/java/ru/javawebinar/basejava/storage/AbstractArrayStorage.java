package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

/**
 * Array based ru.javawebinar.basejava.storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_SIZE = 10000;
    protected Resume[] storage = new Resume[STORAGE_SIZE];
    protected int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public Resume get(String uuid) {
        int index = getIndexOf(uuid);
        if (index != -1) {
            return storage[index];
        } else {
            System.out.println("ru.javawebinar.basejava.model.Resume does not exist in ru.javawebinar.basejava.storage");
        }

        return null;
    }

    protected abstract int getIndexOf(String uuid);
}