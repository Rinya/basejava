package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
    static final int STORAGE_SIZE = 10000;
    protected Resume[] storage = new Resume[STORAGE_SIZE];
    protected int size = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected void saveImpl(Resume resume) {
        if (size == STORAGE_SIZE) {
            throw new StorageException("Can not add more elements.", resume.getUuid());
        }

        saveArrayImp(resume, getIndexOf(resume.getUuid()));
        size++;
    }

    @Override
    protected Resume getImpl(Integer index) {
        return storage[index];
    }

    @Override
    protected void deleteImp(Integer index) {
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
    protected void updateImpl(Integer index, Resume resume) {
        storage[index] = resume;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    protected boolean existInStorage(Integer index) {
        return index >= 0;
    }

    protected abstract void deleteArrayImp(int index);
    protected abstract void saveArrayImp(Resume resume, int index);
}