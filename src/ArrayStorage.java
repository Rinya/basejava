import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
class ArrayStorage {
    private static final int STORAGE_SIZE = 10000;
    private Resume[] storage = new Resume[STORAGE_SIZE];
    private int size = 0;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume resume) {
        if (getIndexOf(resume.uuid) != null) {
            System.out.println("Resume " + resume + " already exists in storage");
        } else if (STORAGE_SIZE == size) {
            System.out.println("Storage is already full");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    Resume get(String uuid) {
        Integer index = getIndexOf(uuid);
        if (index != null) {
            return storage[index];
        } else {
            System.out.println("Resume does not exist in storage");
        }

        return null;
    }

    void delete(String uuid) {
        Integer index = getIndexOf(uuid);
        if (index != null) {
            //Т.к. простой массив, делаем простой заменой элемента
            //System.arraycopy(storage, index + 1, storage, index, (STORAGE_SIZE - index - 1));
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Resume does not exist in storage");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    void update(Resume resume) {
        Integer index = getIndexOf(resume.uuid);
        if (index != null) {
            storage[index] = resume;
        } else {
            System.out.println("Resume " + resume + " does not exists in storage");
        }
    }

    int size() {
        return size;
    }

    private Integer getIndexOf(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                return i;
            }
        }

        return null;
    }
}