package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

/**
 * Array based ru.javawebinar.basejava.storage for Resumes
 */
public interface Storage {
    void clear();

    void save(Resume resume);

    Resume get(String uuid);

    void delete(String uuid);

    /**
     * @return array, contains only Resumes in ru.javawebinar.basejava.storage (without null)
     */
    Resume[] getAll();

    void update(Resume resume);

    int size();
}