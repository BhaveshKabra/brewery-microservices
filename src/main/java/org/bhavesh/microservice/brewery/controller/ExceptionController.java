package org.bhavesh.microservice.brewery.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import org.springframework.validation.BindException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<String>> validationErrorHandler(ConstraintViolationException constraintViolationException)
    {
        List<String> list=new ArrayList<>(constraintViolationException.getConstraintViolations().size());
        constraintViolationException.getConstraintViolations().forEach(violation-> list.add(violation.getPropertyPath()+":"+violation.getMessage()) );
        return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(BindException.class)
    public ResponseEntity<List<ObjectError>> bindErrorHandler(BindException bindException)
    {
        return new ResponseEntity<>(bindException.getAllErrors(), HttpStatus.BAD_REQUEST);
    }
}
