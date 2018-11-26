package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class MapStorage extends AbstractStorage {
    protected Map<String, Resume> storage;

    protected MapStorage(Map<String, Resume> storage) {
        this.storage = storage;
    }

    @Override
    protected List<Resume> getAllFromStorage() {
        return new ArrayList<>(storage.values());
    }

    @Override
    protected void doSave(Resume resume, Object searchKey) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public int size() {
        return storage.size();
    }
}
