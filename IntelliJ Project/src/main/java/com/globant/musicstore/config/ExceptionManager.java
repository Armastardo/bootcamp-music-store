package com.globant.musicstore.config;

import com.globant.musicstore.dto.responseDTO.ResponseDTO;
import com.globant.musicstore.exception.InvalidDataException;
import com.globant.musicstore.exception.ModelNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionManager {
    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<ResponseDTO<String>> handleModelNotFound(ModelNotFoundException modelNotFound) {
        ResponseDTO<String> response = new ResponseDTO<String>("fallo", modelNotFound.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<ResponseDTO<String>> handleInvalidInput(InvalidDataException invalidDataException) {
        ResponseDTO<String> response = new ResponseDTO<String>("fallo", invalidDataException.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
