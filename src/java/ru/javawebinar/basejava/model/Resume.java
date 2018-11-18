package ru.javawebinar.basejava.model;

import java.util.UUID;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume>{
    // Unique identifier
    private final String uuid;
    private final String fullname;

    public Resume(String fullname) {
        this(UUID.randomUUID().toString(), fullname);
    }

    public Resume(String uuid, String fullName) {
        if (fullName == null || fullName.length() == 0) {
            throw new IllegalArgumentException("fullName is empty, for uuid " + uuid);
        }
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
        int fullnameCompare = fullname != null? fullname.compareTo(resume.getFullname()) : -1;
        return fullnameCompare != 0? fullnameCompare : uuid.compareTo(resume.uuid);
    }
}
