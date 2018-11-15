package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;

public class MapResumeStorage extends MapStorage {
    MapResumeStorage() {
        super(new HashMap<>());
    }

    @Override
    protected void doUpdate(Resume resume, Object searchKey) {
        storage.replace(resume.getUuid(), resume);
    }

    @Override
    protected void doDelete(Object searchKey) {
        storage.remove(((Resume)searchKey).getUuid());
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return (Resume)searchKey;
    }
}
