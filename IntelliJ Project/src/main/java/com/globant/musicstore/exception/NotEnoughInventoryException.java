package com.globant.musicstore.exception;

public class NotEnoughInventoryException extends RuntimeException{
    public NotEnoughInventoryException(String message){
        super(message);
    }
}
