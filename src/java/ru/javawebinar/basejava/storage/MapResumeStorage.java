package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.*;

public class MapResumeStorage extends AbstractStorage {
    private final Map<String, Resume> storage;

    MapResumeStorage() {
        this.storage = new HashMap<>();
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
        storage.replace(resume.getUuid(), resume);
    }

    @Override
    protected void doSave(Resume resume, Object searchKey) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void doDelete(Object searchKey) {
        storage.remove(((Resume)searchKey).getUuid());
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return (Resume)searchKey;
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
}
