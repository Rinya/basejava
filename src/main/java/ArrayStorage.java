import java.util.UUID;

class ArrayStorage {
    private static final int storageSize = 10000;
    private Resume[] resumeList = new Resume[storageSize];

    void save(Resume resume) {
        resumeList[size()] = resume;
    }

    void delete(UUID uuid) {
        for (int i = 0; i < size(); i++) {
            if (uuid.equals(resumeList[i].uuid)) {
                System.arraycopy(resumeList, i + 1, resumeList, i, (resumeList.length - (i + 1)));
                break;
            }
        }
    }

    void delete(int index) {
        if (index > size()) {
            throw new IllegalArgumentException("Резюме с индексом " + index + " отсутствует в списке.");
        } else {
            System.arraycopy(resumeList, index + 1, resumeList, index, (resumeList.length - (index + 1)));
        }
    }

    void clear() {
        for (int i = 0; i < storageSize; i++) {
            resumeList[i] = null;
        }
    }

    Resume get(UUID uuid) {
        for (int i = 0; i < size(); i++) {
            if (uuid.equals(resumeList[i].uuid)) {
                return resumeList[i];
            }
        }

        return null;
    }

    int size() {
        int count = 0;
        for (Resume resume : resumeList) {
            if (resume != null) {
                count++;
            }
        }

        return count;
    }

    Resume[] getAll() {
        int size = size();
        Resume resumes[] = new Resume[size];
        System.arraycopy(resumeList, 0, resumes, 0, size);

        return resumes;
    }


}
