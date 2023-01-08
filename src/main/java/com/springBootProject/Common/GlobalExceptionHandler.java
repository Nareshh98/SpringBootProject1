package com.springBootProject.Common;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springBootProject.Exception.NotFoundException;
 

 
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<CustomerErrorResponse> handleNotFoundException(NotFoundException ex) {

        CustomerErrorResponse error =new CustomerErrorResponse();
     //  error.setTimestamp(LocalDateTime.now());
        error.setStatus((HttpStatus.NOT_FOUND).value());
        error.setError(HttpStatus.NOT_FOUND.toString());
        error.setMessage(ex.getMessage());
        error.setLoaclDateTime(LocalDateTime.now());
        return new ResponseEntity<CustomerErrorResponse>(error,HttpStatus.NOT_FOUND);

    }                     
 
}
