package com.mysite.webapp.exception;

public class NotExistStorageException extends StorageException {

    public NotExistStorageException(String uuid) {
        super("resume " + uuid + " not exist", uuid);
    }
}
