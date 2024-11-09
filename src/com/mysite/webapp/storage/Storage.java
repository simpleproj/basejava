package com.mysite.webapp.storage;

import com.mysite.webapp.model.Resume;

public interface Storage {
    Resume get(String uuid);

    Resume[] getAll();

    void save(Resume r);

    void update(Resume resume);

    void delete(String uuid);

    void clear();

    int size();
}
