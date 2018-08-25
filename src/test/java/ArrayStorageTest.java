import model.Resume;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayStorageTest {
    private ArrayStorage arrayStorage;
    private Resume[] original;

    @BeforeEach
    void setUp() {
        original = new Resume[3];
        original[0] = new Resume("Иванов", "Иван", "Иванович");
        original[1] = new Resume("Петров", "Петр", "Петрович");
        original[2] = new Resume("Александоров", "Александр", "Александрович");

        arrayStorage = new ArrayStorage();
    }

    @AfterEach
    void tearDown() {
        arrayStorage = null;
    }

    @Test
    void save() {
        arrayStorage.save(original[0]);

        Resume[] resumes = arrayStorage.getAll();

        assertEquals(1, arrayStorage.size(), "В массиве должен быть 1 элемент");
        assertEquals(original[0].getUuid(), resumes[0].getUuid(), "Сохраненный и полученый резюме не совпадают");
    }

    @Test
    void delete() {
        arrayStorage.save(original[0]);
        arrayStorage.save(original[1]);
        arrayStorage.save(original[2]);

        Resume[] resumes = arrayStorage.getAll();

        assertEquals(3, resumes.length, "В массиве должно быть 3 элемента");

        arrayStorage.delete(original[1].getUuid());

        resumes = arrayStorage.getAll();

        assertEquals(2, resumes.length, "В массиве должно быть 2 элемента");
        assertEquals(original[0].getUuid(), resumes[0].getUuid(), "Первые элементы не совпадают");
        assertEquals(original[2].getUuid(), resumes[1].getUuid(), "Вторые элементы не совпадают");
    }

    @Test
    void deleteByIndex() {
        arrayStorage.save(original[0]);
        arrayStorage.save(original[1]);
        arrayStorage.save(original[2]);

        arrayStorage.delete(1);

        Resume[] resumes = arrayStorage.getAll();

        assertEquals(2, resumes.length, "В массиве должно быть 2 элемента");
        assertEquals(original[0].getUuid(), resumes[0].getUuid(), "Первые элементы не совпадают");
        assertEquals(original[2].getUuid(), resumes[1].getUuid(), "Вторые элементы не совпадают");
    }

    @Test
    void clear() {
        arrayStorage.save(original[0]);
        arrayStorage.save(original[1]);

        Resume[] resumes = arrayStorage.getAll();

        assertEquals(2, resumes.length, "В массиве должно быть 2 элемента");

        arrayStorage.clear();

        resumes = arrayStorage.getAll();

        assertEquals(0, resumes.length, "В массиве не должно быть элементов");
    }

    @Test
    void get() {
        arrayStorage.save(original[0]);
        arrayStorage.save(original[1]);
        arrayStorage.save(original[2]);

        Resume resume = arrayStorage.get(original[1].getUuid());

        assertEquals(original[1], resume, "Полученный элемент не соответствует сохраненному");
    }

    @Test
    void getByFullname() {
        arrayStorage.save(original[0]);
        arrayStorage.save(original[1]);
        arrayStorage.save(original[2]);

        Resume resume = arrayStorage.get(original[2].getFullName());

        assertEquals(original[2], resume, "Полученный элемент не соответствует сохраненному");
    }

    @Test
    void size() {
        arrayStorage.save(original[0]);
        arrayStorage.save(original[1]);
        arrayStorage.save(original[2]);

        assertEquals(3, arrayStorage.size(), "В массиве должно быть 3 элемента");
    }

    @Test
    void getAll() {
        arrayStorage.save(original[0]);
        arrayStorage.save(original[1]);
        arrayStorage.save(original[2]);

        Resume[] resumes = arrayStorage.getAll();

        assertEquals(3, resumes.length, "В массиве должно быть 3 элемента");
        assertArrayEquals(original, resumes, "Где-то ошибка, наборы резюме не совпадают");
    }
}