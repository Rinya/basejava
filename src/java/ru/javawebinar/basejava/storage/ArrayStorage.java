package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based ru.javawebinar.basejava.storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void save(Resume resume) {
        if (getIndexOf(resume.getUuid()) != -1) {
            System.out.println("ru.javawebinar.basejava.model.Resume " + resume + " already exists in ru.javawebinar.basejava.storage");
        } else if (STORAGE_SIZE == size) {
            System.out.println("Storage is already full");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndexOf(uuid);
        if (index != -1) {
            //Т.к. простой массив, делаем простой заменой элемента
            //System.arraycopy(ru.javawebinar.basejava.storage, index + 1, ru.javawebinar.basejava.storage, index, (STORAGE_SIZE - index - 1));
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("ru.javawebinar.basejava.model.Resume does not exist in ru.javawebinar.basejava.storage");
        }
    }

    /**
     * @return array, contains only Resumes in ru.javawebinar.basejava.storage (without null)
     */
    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    public void update(Resume resume) {
        int index = getIndexOf(resume.getUuid());
        if (index != -1) {
            storage[index] = resume;
        } else {
            System.out.println("ru.javawebinar.basejava.model.Resume " + resume + " does not exists in ru.javawebinar.basejava.storage");
        }
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