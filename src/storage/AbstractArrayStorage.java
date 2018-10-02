package storage;

import model.Resume;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_SIZE = 10000;
    protected Resume[] storage = new Resume[STORAGE_SIZE];
    protected int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public Resume get(String uuid) {
        int index = getIndexOf(uuid);
        if (index != -1) {
            return storage[index];
        } else {
            System.out.println("model.Resume does not exist in storage");
        }

        return null;
    }

    protected abstract int getIndexOf(String uuid);
}