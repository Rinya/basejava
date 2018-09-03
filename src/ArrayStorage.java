import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
class ArrayStorage {
    private static final int STORAGE_SIZE = 10000;
    private Resume[] storage = new Resume[STORAGE_SIZE];
    private int size = 0;

    void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    void save(Resume resume) {
        if (existsInStorage(resume.uuid) != null) {
            System.out.println("Resume " + resume + " already exists in storage");
        } else if (STORAGE_SIZE == size) {
            System.out.println("Storage is already full");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    Resume get(String uuid) {
        Integer index = existsInStorage(uuid);
        if (index != null) {
            return storage[index];
        } else {
            System.out.println("Resume does not exist in storage");
        }

        return null;
    }

    void delete(String uuid) {
        Integer index = existsInStorage(uuid);
        if (index != null) {
            System.arraycopy(storage, index + 1, storage, index, (storage.length - index - 1));
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
        if (resume != null) {
            Integer index = existsInStorage(resume.uuid);
            if (index != null) {
                storage[index] = resume;
            } else {
                System.out.println("Resume " + resume + " does not exists in storage");
            }
        } else {
            System.out.println("Resume " + resume + " does not exists");
        }
    }

    int size() {
        return size;
    }

    private Integer existsInStorage(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                //return storage[i];
                return i;
            }
        }

        return null;
    }
}