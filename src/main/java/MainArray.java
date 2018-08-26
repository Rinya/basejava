import model.Resume;

import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

public class MainArray {

    public static void main(String[] args) {
        ArrayStorage arrayStorage = new ArrayStorage();
        Resume firstResume = new Resume();
        firstResume.uuid = UUID.randomUUID();
        Resume secondResume = new Resume();
        secondResume.uuid = UUID.randomUUID();
        Resume thirdResume = new Resume();
        thirdResume.uuid = UUID.randomUUID();

        arrayStorage.save(firstResume);
        arrayStorage.save(secondResume);
        arrayStorage.save(thirdResume);
        Resume[] resumeList = arrayStorage.getAll();
        Stream.of(resumeList).forEach(System.out::println);
        System.out.println("----------------------------");

        Resume resume = arrayStorage.get(thirdResume.uuid);
        if (Objects.nonNull(resume)) {
            Resume fourthResume = new Resume();
            fourthResume.uuid = UUID.randomUUID();
            arrayStorage.save(fourthResume);
        }

        if (arrayStorage.size() == 4) {
            arrayStorage.delete(1);
        }

        resumeList = arrayStorage.getAll();
        Stream.of(resumeList).forEach(System.out::println);

        arrayStorage.clear();
    }
}
