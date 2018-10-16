package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {
    @Override
    public Resume get(String uuid) {
        return getImpl(checkExistUUIDInStorage(uuid));
    }

    @Override
    public void update(Resume resume) {
        updateImpl(checkExistUUIDInStorage(resume.getUuid()), resume);
    }

    @Override
    public void delete(String uuid) {
        deleteImp(checkExistUUIDInStorage(uuid));
    }

    protected int checkExistUUIDInStorage(String uuid) {
        int index = getIndexOf(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return index;
    }

    protected abstract void deleteImp(int index);
    protected abstract void updateImpl(int index, Resume resume);
    protected abstract Resume getImpl(int index);
    protected abstract int getIndexOf(String uuid);
}
