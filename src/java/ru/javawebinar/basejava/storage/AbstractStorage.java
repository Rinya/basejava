package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage implements Storage {
    @Override
    public Resume get(String uuid) {
        return doGet(getExistedSearchKey(uuid));
    }

    @Override
    public void update(Resume resume) {
        doUpdate(resume, getExistedSearchKey(resume.getUuid()));
    }

    @Override
    public void delete(String uuid) {
        doDelete(getExistedSearchKey(uuid));
    }

    @Override
    public void save(Resume resume) {
        doSave(resume, getNotExistedSearchKey(resume.getUuid()));
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> resumeList = getAllFromStorage();
        Collections.sort(resumeList);
        return resumeList;
    }

    protected abstract List<Resume> getAllFromStorage();

    protected abstract Object getSearchKey(String condition);

    protected abstract boolean isExist(Object searchKey);

    protected abstract void doUpdate(Resume resume, Object searchKey);

    protected abstract void doSave(Resume resume, Object searchKey);

    protected abstract void doDelete(Object searchKey);

    protected abstract Resume doGet(Object searchKey);

    private Object getExistedSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object getNotExistedSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }

        return searchKey;
    }
}
