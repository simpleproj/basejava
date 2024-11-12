package com.mysite.webapp.storage;

import com.mysite.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    final public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index > 0) {
            return storage[index];
        }
        System.out.println("Resume with " + uuid + " not found.");
        return null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    final public void save(Resume r) {
        if (size == STORAGE_LIMIT) {
            System.out.println("Storage already overflow");
        } else {

            int index = getIndex(r.getUuid());
            if (index > 0) {
                System.out.println("Resume with " + r.getUuid() + " exist.");
            } else {
                insertElement(r, index);
                size++;
            }
        }
    }

    final public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index > 0) {
            storage[index] = r;
        } else {
            System.out.println("Resume with " + r.getUuid() + " not found.");
        }
    }

    final public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            size--;
            fillRemovedElement(index);
            storage[size] = null;
        } else {
            System.out.println("Resume with " + uuid + " not found.");
        }
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    protected abstract void insertElement(Resume r, int index);

    protected abstract void fillRemovedElement(int index);

    protected abstract int getIndex(String uuid);

}
