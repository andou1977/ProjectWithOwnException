package com.example.merde;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GestionnaireExceptions {


    @ExceptionHandler(MyException.class)
    public ResponseEntity<String> handleCustomException(MyException ex) {
        return new ResponseEntity<>("Erreur : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
