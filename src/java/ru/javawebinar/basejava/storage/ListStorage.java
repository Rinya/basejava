package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {
    private List<Resume> storage;

    public ListStorage() {
        this.storage = new ArrayList<>();
    }

    @Override
    protected boolean existInStorage(Integer index) {
        return !(index == -1);
    }

    @Override
    protected Integer getIndexOf(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (uuid.equals(storage.get(i).getUuid())) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    protected void saveImpl(Resume resume) {
        storage.add(resume);
    }

    @Override
    protected Resume getImpl(Integer index) {
        return storage.get(index);
    }

    @Override
    protected void deleteImp(Integer index) {
        storage.remove(index.intValue());
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }

    @Override
    protected void updateImpl(Integer index, Resume resume) {
        storage.set(index, resume);
    }

    @Override
    public int size() {
        return storage.size();
    }
}
