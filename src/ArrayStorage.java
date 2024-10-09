import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (r.uuid.equals(storage[i].uuid)) {
                index = i;
            }
        }

        if (index != -1) {
            System.out.println("Resume with " + r.uuid + " exist.");
        } else if (size == storage.length) {
            System.out.println("Storage already overflow");
        } else {
            storage[size] = r;
            size++;
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                return storage[i];
            }
        }
        System.out.println("Resume with " + uuid + " not found.");
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                size--;
                storage[i] = storage[size];
                storage[size] = null;
                return;
            }
        }
        System.out.println("Resume with " + uuid + " not found.");
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] allResumes = new Resume[size];
        for (int i = 0; i < size; i++) {
            allResumes[i] = storage[i];
        }
        return allResumes;
    }

    int size() {
        return size;
    }
}
