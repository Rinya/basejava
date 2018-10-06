package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based ru.javawebinar.basejava.storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    static final int STORAGE_SIZE = 10000;
    protected Resume[] storage = new Resume[STORAGE_SIZE];
    protected int size = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public Resume get(String uuid) {
        int index = getIndexOf(uuid);
        if (index >= 0) {
            return storage[index];
        } else {
            System.out.println("Resume does not exist in storage");
        }

        return null;
    }

    @Override
    public void delete(String uuid) {
        int index = getIndexOf(uuid);

        if (index < 0) {
            System.out.println("Resume does not exist in storage");
        } else {
            deleteImp(uuid, index);
        }
    }

    protected abstract void deleteImp(String uuid, int index);

    /**
     * @return array, contains only Resumes in ru.javawebinar.basejava.storage (without null)
     */
    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    public void update(Resume resume) {
        int index = getIndexOf(resume.getUuid());
        if (index >= 0) {
            storage[index] = resume;
        } else {
            System.out.println("Resume " + resume + " does not exists in storage");
        }
    }

    @Override
    public int size() {
        return size;
    }

    protected abstract int getIndexOf(String uuid);
}