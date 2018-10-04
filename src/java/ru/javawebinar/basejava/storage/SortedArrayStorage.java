package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void save(Resume resume) {
        if (size() == STORAGE_SIZE) {
            throw new IllegalStateException("Can not add more elements.");
        }

        int index = getIndexOf(resume.getUuid());

        if (index < 0) {
            index = -index - 1;
        } else {
            throw new IllegalArgumentException("Resume " + resume + " already exists in storage");
        }

        System.arraycopy(storage, index, storage, index + 1,size() - index);
        storage[index] = resume;
        size++;
    }

    @Override
    public void delete(String uuid) {
        int index = getIndexOf(uuid);
        System.out.println("delete index " + index);

        if (index < 0) {
            throw new IllegalArgumentException("Resume does not exist in storage");
        } else {
            System.arraycopy(storage, index + 1, storage, index, size() - index - 1);
            storage[--size] = null;
        }
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    public void update(Resume resume) {
        int index = getIndexOf(resume.getUuid());
        if (index >= 0) {
            storage[index] = resume;
        } else {
            System.out.println("Resume " + resume + " does not exists in storage");
        }
    }

    @Override
    protected int getIndexOf(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
