package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

/**
 * Array based ru.javawebinar.basejava.storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    @Override
    public void save(Resume resume) {
        if (getIndexOf(resume.getUuid()) >= 0) {
            System.out.println("Resume " + resume + " already exists in storage");
        } else if (STORAGE_SIZE == size) {
            System.out.println("Storage is already full");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    @Override
    protected void deleteImp(String uuid, int index) {
        storage[index] = storage[--size];
        storage[size] = null;
    }

    @Override
    protected int getIndexOf(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }

        return -1;
    }
}