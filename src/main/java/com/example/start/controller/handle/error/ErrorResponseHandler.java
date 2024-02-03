package com.example.start.controller.handle.error;

import com.example.start.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorResponseHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {
        StringBuilder errors = new StringBuilder();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String errorMessage = error.getDefaultMessage();
            errors.append(errorMessage).append(", ");
        });

        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setError(errors.toString().trim());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
