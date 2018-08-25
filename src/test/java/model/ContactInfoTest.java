package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContactInfoTest {
    private ContactInfo contactInfo;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void phone() {
        contactInfo = new ContactInfo(ContactType.PHONE, "4563");

        assertFalse(contactInfo.isUrl(),"У данного контакта не должно быть признака isUrl = true");
    }

    @Test
    void skype() {
        contactInfo = new ContactInfo(ContactType.SKYPE, "4563", "http://www.yandex.ru");

        assertTrue(contactInfo.isUrl(), "У данного контакта должен быть признак isUrl = true");
    }
}