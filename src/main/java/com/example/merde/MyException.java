package com.example.merde;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


public class MyException extends  RuntimeException{

    public MyException(String message){
         super(message);

    }
}
