package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResumeTest {
    private Resume resume;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getFullName() {
        resume = new Resume("Акжигитов", "Ринат", "Рашитович");
        System.out.println(resume.getFullName());

        resume = new Resume("", "Ринат", "Рашитович");
        System.out.println(resume.getFullName());

        resume = new Resume(null, "Ринат", "Рашитович");
        System.out.println(resume.getFullName());

        resume = new Resume("Акжигитов", "", "Рашитович");
        System.out.println(resume.getFullName());

        resume = new Resume("Акжигитов", "Ринат", null);
        System.out.println(resume.getFullName());
    }
}