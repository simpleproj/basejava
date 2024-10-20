package com.mysite.webapp.storage;

import com.mysite.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;

/** old implementation
 *       for (int i = 0; i < size; i++) {
 *           storage[i] = null;
 *       }
 *       size = 0;
 *   }
 */
    }

    public void save(Resume r) {
        if (getIndex(r.getUuid()) == -1) {
            storage[size] = r;
            size++;
        } else if (size == storage.length) {
            System.out.println("Storage already overflow");
        } else {
            System.out.println("Resume with " + r.getUuid() + " exist.");
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            return storage[index];
        }
        System.out.println("Resume with " + uuid + " not found.");
        return null;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            size--;
            storage[index] = storage[size];
            storage[size] = null;
        } else {
            System.out.println("Resume with " + uuid + " not found.");
        }
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index != 1) {
            storage[index] = resume;
        } else {
            System.out.println("Resume with " + resume.getUuid() + " not found.");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);

/** old implementation
 *       Resume[] allResumes = new Resume[size];
 *       for (int i = 0; i < size; i++) {
 *           allResumes[i] = storage[i];
 *       }
 *       return allResumes;
 */
    }

    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
