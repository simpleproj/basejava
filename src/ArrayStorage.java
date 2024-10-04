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
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if (r.uuid.equals(storage[i].uuid)) {
                flag = true;
            }
        }

        if (flag) {
            System.out.println("Resume with " + r.uuid + " exist.");
        } else if (size == storage.length) {
            System.out.println("Storage already overflow");
        } else {
            storage[size] = r;
            size++;
        }
    }

    Resume get(String uuid) {
        for (Resume resume : storage) {
            if (resume != null) {
                if (resume.uuid.equals(uuid)) {
                    return resume;
                }
            }
        }
        System.out.println("Resume with " + uuid + " not found.");
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                return;
            } else {
                System.out.println("Resume with " + uuid + " not found.");
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] result = new Resume[size];
        for (int i = 0; i < size; i++) {
            result[i] = storage[i];
        }
        return result;
    }

    int size() {
        return size;
    }
}
