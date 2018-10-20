package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListStorage extends AbstractStorage<Integer> {
    private List<Resume> storage;

    public ListStorage() {
        this.storage = new ArrayList<>();
    }

    @Override
    protected boolean existInStorage(Resume resume) {
        return !notExistInStorage(resume.getUuid());
    }

    @Override
    protected boolean notExistInStorage(String uuid) {
        return getIndexOf(uuid) == -1;
    }

    @Override
    protected Integer getIndexOf(String uuid) {
        Optional<Resume> optionalResume = storage
                .stream()
                .filter(item -> uuid.equals(item.getUuid())).findFirst();

        return storage.indexOf(optionalResume.orElse(null));

        /*for (Resume resume: storage) {
          if (uuid.equals(resume.getUuid())) {
              return storage.indexOf(resume);
          }
        }

        return null;*/
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
