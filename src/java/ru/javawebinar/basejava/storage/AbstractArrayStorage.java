package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.List;

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
    protected List<Resume> getAllFromStorage() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, size));
    }

    @Override
    protected boolean isExist(Object index) {
        return (int)index >= 0;
    }

    @Override
    protected void doUpdate(Resume resume, Object index) {
        storage[(int) index] = resume;
    }

    @Override
    protected void doSave(Resume resume, Object searchKey) {
        if (size == STORAGE_SIZE) {
            throw new StorageException("Storage overflow", resume.getUuid());
        } else {
            insertElement(resume, (int)searchKey);
            size++;
        }
    }

    @Override
    protected void doDelete(Object index) {
        fillDeletedElement((int)index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected Resume doGet(Object index) {
        return storage[(int) index];
    }

    @Override
    public int size() {
        return size;
    }

    protected abstract Integer getSearchKey(String condition);
    protected abstract void insertElement(Resume resume, int index);
    protected abstract void fillDeletedElement(int index);
}