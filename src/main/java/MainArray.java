import model.Resume;

import java.util.Objects;
import java.util.stream.Stream;

public class MainArray {

    public static void main(String[] args) {
        ArrayStorage arrayStorage = new ArrayStorage();
        arrayStorage.save(new Resume("Иванов", "Иван", "Иванович"));
        arrayStorage.save(new Resume("Петров", "Петр", "Петрович"));
        arrayStorage.save(new Resume("Александоров", "Александр", "Александрович"));
        Resume[] resumeList = arrayStorage.getAll();
        Stream.of(resumeList).forEach(System.out::println);
        System.out.println("----------------------------");

        Resume resume = arrayStorage.get("Петров Петр петрович");
        if (Objects.nonNull(resume)) {
            arrayStorage.save(new Resume("Петров", "Петр", "Петрович"));
        }

        if (arrayStorage.size() == 4) {
            arrayStorage.delete(1);
        }

        resumeList = arrayStorage.getAll();
        Stream.of(resumeList).forEach(System.out::println);

        arrayStorage.clear();
    }
}
