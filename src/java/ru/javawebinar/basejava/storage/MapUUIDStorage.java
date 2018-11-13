package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.*;

public class MapUUIDStorage extends AbstractStorage {
    private Map<String, Resume> storage;

    public MapUUIDStorage() {
        this.storage = new HashMap<>();
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> values = new ArrayList<>(storage.values());
        Collections.sort(values);
        return values;
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected Object getSearchKey(String condition) {
        return storage.get(condition);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    protected void doUpdate(Resume resume, Object searchKey) {
        storage.replace(((Resume)searchKey).getUuid(), resume);
    }

    @Override
    protected void doSave(Resume resume, Object searchKey) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void doDelete(Object searchKey) {
        storage.remove(String.valueOf(searchKey));
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return storage.get(String.valueOf(searchKey));
    }
}
