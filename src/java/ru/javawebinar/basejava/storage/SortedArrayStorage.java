package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    protected void saveImp(Resume resume, int index) {
        index = -index - 1;
        System.arraycopy(storage, index, storage, index + 1,size - index);
        storage[index] = resume;
    }

    @Override
    protected void deleteImp(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index - 1);
        size--;
    }

    @Override
    protected int getIndexOf(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
