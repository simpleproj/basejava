package com.mysite.webapp.storage;

import com.mysite.webapp.model.Resume;

import java.util.List;

public interface Storage {
    Resume get(String uuid);

    List<Resume> getAllSorted();

    void save(Resume r);

    void update(Resume resume);

    void delete(String uuid);

    void clear();

    int size();
}
