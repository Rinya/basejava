package interfaces;

import model.Resume;

import java.util.UUID;

public interface Storage {
    void save(Resume resume);
    void delete(UUID uuid);
    void delete(int index);
    void clear();
    Resume get(UUID uuid);
    Resume get(String fullname);
    int size();
    Resume[] getAll();
}
