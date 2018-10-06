package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    public void save(Resume resume) {
        if (size == STORAGE_SIZE) {
            System.out.println("Can not add more elements.");
        }

        int index = getIndexOf(resume.getUuid());

        if (index < 0) {
            index = -index - 1;
        } else {
            System.out.println("Resume " + resume + " already exists in storage");
        }

        System.arraycopy(storage, index, storage, index + 1,size - index);
        storage[index] = resume;
        size++;
    }

    @Override
    protected void deleteImp(String uuid, int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index - 1);
        storage[--size] = null;
    }

    @Override
    protected int getIndexOf(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
