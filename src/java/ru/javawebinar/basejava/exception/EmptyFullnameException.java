package ru.javawebinar.basejava.exception;

public class EmptyFullnameException extends RuntimeException {
    private final String uuid;

    public EmptyFullnameException(String uuid) {
        super("Fullname is empty");
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }
}
