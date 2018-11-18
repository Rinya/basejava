package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {
    static final Comparator<Resume> RESUME_COMPARATOR = (first, second) -> {
        if (first == null && second == null) {
            return 0;
        } else if (first == null) {
            return -1;
        } else  if (second == null) {
            return 1;
        }

        return first.getUuid().compareTo(second.getUuid());
    };

    @Override
    protected Integer getSearchKey(String condition) {
        Resume searchKey = new Resume(condition, "Some Fullname");
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
    }

    @Override
    protected void insertElement(Resume resume, int index) {
        int insertIndex = -index - 1;
        System.arraycopy(storage, insertIndex, storage, insertIndex + 1,size - insertIndex);
        storage[insertIndex] = resume;
    }

    @Override
    protected void fillDeletedElement(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index - 1);
    }
}
