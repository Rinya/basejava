package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;

public class MapUUIDStorage extends MapStorage {
    MapUUIDStorage() {
        super(new HashMap<>());
    }

    @Override
    protected Object getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return storage.containsKey(String.valueOf(searchKey));
    }

    @Override
    protected void doUpdate(Resume resume, Object searchKey) {
        storage.replace(String.valueOf(searchKey), resume);
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
