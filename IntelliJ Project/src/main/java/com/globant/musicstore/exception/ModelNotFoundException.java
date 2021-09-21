package com.globant.musicstore.exception;

import java.util.NoSuchElementException;

public class ModelNotFoundException extends NoSuchElementException {
    public ModelNotFoundException(String message) {
        super(message);
    }
}
