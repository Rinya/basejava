package ru.javawebinar.basejava.storage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.model.Resume;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayStorageTest {
    private ArrayStorage arrayStorage;
    private Resume[] original;

    @Before
    public void setUp() {
        original = new Resume[3];
        original[0] = new Resume();
        original[0].setUuid(UUID.randomUUID().toString());
        original[1] = new Resume();
        original[1].setUuid(UUID.randomUUID().toString());
        original[2] = new Resume();
        original[2].setUuid(UUID.randomUUID().toString());

        arrayStorage = new ArrayStorage();
    }

    @After
    public void tearDown() {
        arrayStorage = null;
    }

    @Test
    public void save() {
        arrayStorage.save(original[0]);

        Resume[] resumes = arrayStorage.getAll();

        assertEquals(1, arrayStorage.size(), "В массиве должен быть 1 элемент");
        assertEquals(original[0].getUuid(), resumes[0].getUuid(), "Сохраненный и полученый резюме не совпадают");
    }

    @Test
    public void delete() {
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
    public void clear() {
        arrayStorage.save(original[0]);
        arrayStorage.save(original[1]);

        Resume[] resumes = arrayStorage.getAll();

        assertEquals(2, resumes.length, "В массиве должно быть 2 элемента");

        arrayStorage.clear();

        resumes = arrayStorage.getAll();

        assertEquals(0, resumes.length, "В массиве не должно быть элементов");
    }

    @Test
    public void get() {
        arrayStorage.save(original[0]);
        arrayStorage.save(original[1]);
        arrayStorage.save(original[2]);

        Resume resume = arrayStorage.get(original[1].getUuid());

        assertEquals(original[1], resume, "Полученный элемент не соответствует сохраненному");
    }

    @Test
    public void size() {
        arrayStorage.save(original[0]);
        arrayStorage.save(original[1]);
        arrayStorage.save(original[2]);

        assertEquals(3, arrayStorage.size(), "В массиве должно быть 3 элемента");
    }

    @Test
    public void getAll() {
        arrayStorage.save(original[0]);
        arrayStorage.save(original[1]);
        arrayStorage.save(original[2]);

        Resume[] resumes = arrayStorage.getAll();

        assertEquals(3, resumes.length, "В массиве должно быть 3 элемента");
        assertArrayEquals(original, resumes, "Где-то ошибка, наборы резюме не совпадают");
    }

    @Test
    public void update() {
        arrayStorage.save(original[0]);
        arrayStorage.save(original[1]);
        arrayStorage.save(original[2]);

        assertEquals(3, arrayStorage.size(), "В массиве должно быть 3 элемента");

        Resume resume = new Resume();
        resume.setUuid(original[1].getUuid());

        arrayStorage.update(resume);

        assertEquals(resume, arrayStorage.get(resume.getUuid()), "Обновление не произошло, разные объекты");
    }
}