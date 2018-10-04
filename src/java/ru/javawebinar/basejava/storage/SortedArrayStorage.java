package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    public void clear() {

    }

    @Override
    public void save(Resume resume) {
        if (size() == STORAGE_SIZE) {
            throw new IllegalStateException("Can not add more elements.");
        }

        int index = getIndexOf(resume.getUuid());
        System.out.println("index: " + index);

        if (index < 0) {
            index = -index - 1;
            System.out.println("insertIndex: " + index);
        }

        storage[index] = resume;
        //System.arraycopy(storage, index, storage, index + 1, size() - index);
        System.out.println(Arrays.toString(storage));
    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public void update(Resume resume) {

    }

    @Override
    protected int getIndexOf(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
