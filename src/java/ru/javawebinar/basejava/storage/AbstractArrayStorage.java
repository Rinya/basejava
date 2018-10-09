package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    private static final int STORAGE_SIZE = 10000;
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
    public Resume get(String uuid) {
        int index = getIndexOf(uuid);
        if (index >= 0) {
            return storage[index];
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndexOf(uuid);

        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            deleteImp(index);
            storage[--size] = null;
        }
    }

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
            throw new NotExistStorageException(resume.getUuid());
        }
    }

    @Override
    public int size() {
        return size;
    }

    protected abstract void saveImp(Resume resume, int index);

    protected abstract void deleteImp(int index);

    protected abstract int getIndexOf(String uuid);
}