package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {
    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());
    @Override
    public Resume get(String uuid) {
        LOG.info("Get " + uuid);
        return doGet(getExistedSearchKey(uuid));
    }

    @Override
    public void update(Resume resume) {
        LOG.info("Update " + resume);
        doUpdate(resume, getExistedSearchKey(resume.getUuid()));
    }

    @Override
    public void delete(String uuid) {
        LOG.info("Delete " + uuid);
        doDelete(getExistedSearchKey(uuid));
    }

    @Override
    public void save(Resume resume) {
        LOG.info("Save " + resume);
        doSave(resume, getNotExistedSearchKey(resume.getUuid()));
    }

    @Override
    public List<Resume> getAllSorted() {
        LOG.info("GetAllSorted");
        List<Resume> resumeList = doCopyAll();
        Collections.sort(resumeList);
        return resumeList;
    }

    protected abstract List<Resume> doCopyAll();

    protected abstract SK getSearchKey(String condition);

    protected abstract boolean isExist(SK searchKey);

    protected abstract void doUpdate(Resume resume, SK searchKey);

    protected abstract void doSave(Resume resume, SK searchKey);

    protected abstract void doDelete(SK searchKey);

    protected abstract Resume doGet(SK searchKey);

    private SK getExistedSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            LOG.warning("Resume " + uuid + " not exist");
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private SK getNotExistedSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            LOG.warning("Resume " + uuid + " already exist");
            throw new ExistStorageException(uuid);
        }

        return searchKey;
    }
}
