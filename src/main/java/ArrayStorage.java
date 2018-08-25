import interfaces.Storage;
import model.Resume;
import utils.StringUtils;

import java.util.Objects;
import java.util.UUID;

public class ArrayStorage implements Storage {
    private static final int storageSize = 10000;
    private Resume[] resumeList;

    public ArrayStorage() {
        this.resumeList = new Resume[storageSize];
    }

    @Override
    public void save(Resume resume) {
        resumeList[size()] = resume;
    }

    @Override
    public void delete(UUID uuid) {
        for (int i = 0; i < size(); i++) {
            if (uuid.equals(resumeList[i].getUuid())) {
                System.arraycopy(resumeList, i + 1, resumeList, i, (resumeList.length - (i + 1)));
                break;
            }
        }
    }

    @Override
    public void delete(int index) {
        if (index > size()) {
            throw new RuntimeException("Резюме с индексом " + index + " отсутствует в списке.");
        } else {
            System.arraycopy(resumeList, index + 1, resumeList, index, (resumeList.length - (index + 1)));
        }
    }

    @Override
    public void clear() {
        int iterrateStep = storageSize / 10;
        int iterrateSecondStep = iterrateStep * 2;
        int iterrateThirdStep = iterrateStep * 3;
        int iterrateFourthStep = iterrateStep * 4;
        int iterrateFifthStep = iterrateStep * 5;
        int iterrateSixthStep = iterrateStep * 6;
        int iterrateSeventhStep = iterrateStep * 7;
        int iterrateEightthStep = iterrateStep * 8;
        int iterrateNinethStep = iterrateStep * 9;

        for (int i = 0; i < iterrateStep; i++) {
            resumeList[i] = null;
            resumeList[i + (iterrateStep)] = null;
            resumeList[i + iterrateSecondStep] = null;
            resumeList[i + iterrateThirdStep] = null;
            resumeList[i + iterrateFourthStep] = null;
            resumeList[i + iterrateFifthStep] = null;
            resumeList[i + iterrateSixthStep] = null;
            resumeList[i + iterrateSeventhStep] = null;
            resumeList[i + iterrateEightthStep] = null;
            resumeList[i + iterrateNinethStep] = null;
        }
    }

    @Override
    public Resume get(UUID uuid) {
        for (int i = 0; i < size(); i++) {
            if (uuid.equals(resumeList[i].getUuid())) {
                return resumeList[i];
            }
        }

        return null;
    }

    @Override
    public Resume get(String fullname) {
        if (StringUtils.isNotEmpty(fullname)) {
            for (int i = 0; i < size(); i++) {
                if (fullname.equalsIgnoreCase(resumeList[i].getFullName())) {
                    return resumeList[i];
                }
            }
        }

        return null;
    }

    @Override
    public int size() {
        int count = 0;
        Resume previous = null;
        for (Resume resume : resumeList) {
            if (Objects.nonNull(resume)) {
                count++;
            } else if (Objects.isNull(previous)) {
                break;
            }
            previous = resume;
        }

        return count;
    }

    @Override
    public Resume[] getAll() {
        int size = size();
        Resume resumes[] = new Resume[size];
        System.arraycopy(resumeList, 0, resumes, 0, size);

        return resumes;
    }


}
