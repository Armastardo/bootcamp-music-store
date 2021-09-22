package com.globant.musicstore.config;

import com.globant.musicstore.dto.responseDTO.ResponseDTO;
import com.globant.musicstore.exception.InvalidDataException;
import com.globant.musicstore.exception.ModelNotFoundException;
import com.globant.musicstore.utils.constants.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionManager {
    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<ResponseDTO<String>> handleModelNotFound(ModelNotFoundException modelNotFound) {
        ResponseDTO<String> response = new ResponseDTO<String>(Constants.RESPONSE_MODEL_NOT_FOUND, modelNotFound.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<ResponseDTO<String>> handleInvalidInput(InvalidDataException invalidDataException) {
        ResponseDTO<String> response = new ResponseDTO<String>(Constants.RESPONSE_INVALID_DATA_INPUT, invalidDataException.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
