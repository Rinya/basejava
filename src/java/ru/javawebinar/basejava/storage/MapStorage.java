package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> storage;

    public MapStorage() {
        this.storage = new HashMap<>();
    }

    @Override
    public void delete(String uuid) {
        checkExistUUIDInStorage(uuid);
        storage.remove(uuid);
    }

    @Override
    protected void deleteImp(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Resume resume) {
        checkExistUUIDInStorage(resume.getUuid());
        storage.replace(resume.getUuid(), resume);
    }

    @Override
    protected void updateImpl(int index, Resume resume) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Resume get(String uuid) {
        checkExistUUIDInStorage(uuid);
        return storage.get(uuid);
    }

    @Override
    protected Resume getImpl(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected int getIndexOf(String uuid) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public void save(Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    public Resume[] getAll() {
        return storage.values().toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected int checkExistUUIDInStorage(String uuid) {
        if (!storage.containsKey(uuid))
            throw new NotExistStorageException(uuid);

        return 0;
    }
}
