package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage<T> implements Storage {
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

    @Override
    public void save(Resume resume) {
        T index = getIndexOf(resume.getUuid());
        if (existInStorage(index)) {
            throw new ExistStorageException(resume.getUuid());
        }

        saveImpl(resume);
    }

    private T checkExistUUIDInStorage(String uuid) {
        T index = getIndexOf(uuid);
        if (!existInStorage(index)) {
            throw new NotExistStorageException(uuid);
        }

        return index;
    }

    protected abstract boolean existInStorage(T resume);

    protected abstract void saveImpl(Resume resume);
    protected abstract void deleteImp(T index);
    protected abstract void updateImpl(T index, Resume resume);
    protected abstract Resume getImpl(T index);
    protected abstract T getIndexOf(String uuid);
}
