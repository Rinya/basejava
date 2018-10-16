package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
    static final int STORAGE_SIZE = 10000;
    protected Resume[] storage = new Resume[STORAGE_SIZE];
    protected int size = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void save(Resume resume) {
        if (size == STORAGE_SIZE) {
            throw new StorageException("Can not add more elements.", resume.getUuid());
        }

        int index = getIndexOf(resume.getUuid());

        if (index < 0) {
            saveImp(resume, index);
            size++;
        } else {
            throw new ExistStorageException(resume.getUuid());
        }
    }

    @Override
    protected Resume getImpl(int index) {
        return storage[index];
    }

    @Override
    protected void deleteImp(int index) {
        deleteArrayImp(index);
        storage[--size] = null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    protected void updateImpl(int index, Resume resume) {
        storage[index] = resume;
    }

    @Override
    public int size() {
        return size;
    }

    protected abstract void deleteArrayImp(int index);
    protected abstract void saveImp(Resume resume, int index);
}