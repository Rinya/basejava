package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    protected void saveImp(Resume resume, int index) {
        int indertIndex = -index - 1;
        System.arraycopy(storage, indertIndex, storage, indertIndex + 1,size - indertIndex);
        storage[indertIndex] = resume;
    }

    @Override
    protected void deleteArrayImp(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index - 1);
    }

    @Override
    protected int getIndexOf(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
