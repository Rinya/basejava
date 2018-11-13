package ru.javawebinar.basejava.model;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume>{
    // Unique identifier
    private final String uuid;
    private final String fullname;

    public Resume() {
        this(UUID.randomUUID().toString(), null);
    }

    public Resume(String uuid) {
        this.uuid = uuid;
        this.fullname = null;
    }

    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullname = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullname() {
        return fullname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resume)) return false;

        Resume resume = (Resume) o;
        return uuid.equals(resume.uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public String toString() {
        return uuid;
    }

    @Override
    public int compareTo(Resume resume) {
        int fullnameCompare = StringUtils.compare(fullname, resume.getFullname());
        int uuidCompare = uuid.compareTo(resume.uuid);
        return uuidCompare < fullnameCompare? uuidCompare : fullnameCompare;
    }
}
