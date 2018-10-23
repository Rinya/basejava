package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage<String> {
    private Map<String, Resume> storage;

    public MapStorage() {
        this.storage = new HashMap<>();
    }

    @Override
    protected boolean existInStorage(String index) {
        return index != null;
    }

    @Override
    protected void saveImpl(Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void deleteImp(String index) {
        storage.remove(index);
    }

    @Override
    protected void updateImpl(String index, Resume resume) {
        storage.replace(index, resume);
    }

    @Override
    protected Resume getImpl(String index) {
        return storage.get(index);
    }

    @Override
    protected String getIndexOf(String uuid) {
        return storage.containsKey(uuid)? uuid : null;
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        return storage.values().toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storage.size();
    }
}
