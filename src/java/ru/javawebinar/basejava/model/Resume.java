package ru.javawebinar.basejava.model;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume> {
    // Unique identifier
    private final String uuid;
    private final String fullName;
    private Map<ContactType, String> contacts;
    private Map<SectionType, Section> sections;

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        Objects.requireNonNull(fullName, "fullName must not be null");

        this.uuid = uuid;
        this.fullName = fullName;
        this.contacts = new EnumMap<>(ContactType.class);
        this.sections = new EnumMap<>(SectionType.class);
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public Map<ContactType, String> getContacts() {
        return contacts;
    }

    public Map<SectionType, Section> getSections() {
        return sections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resume)) return false;

        Resume resume = (Resume) o;

        if (!getUuid().equals(resume.getUuid())) return false;
        if (!getFullName().equals(resume.getFullName())) return false;
        if (getContacts() != null ? !getContacts().equals(resume.getContacts()) : resume.getContacts() != null)
            return false;
        return getSections() != null ? getSections().equals(resume.getSections()) : resume.getSections() == null;
    }

    @Override
    public int hashCode() {
        int result = getUuid().hashCode();
        result = 31 * result + getFullName().hashCode();
        result = 31 * result + (getContacts() != null ? getContacts().hashCode() : 0);
        result = 31 * result + (getSections() != null ? getSections().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return uuid + ", " +
                fullName + ", " +
                contacts + ", " +
                sections;
    }

    @Override
    public int compareTo(Resume resume) {
        int fullNameCompare = fullName.compareTo(resume.getFullName());
        return fullNameCompare != 0 ? fullNameCompare : uuid.compareTo(resume.uuid);
    }
}
