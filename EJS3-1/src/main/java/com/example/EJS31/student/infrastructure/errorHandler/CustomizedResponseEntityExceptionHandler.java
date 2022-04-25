package com.example.EJS31.student.infrastructure.errorHandler;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(
            ChangeSetPersister.NotFoundException ex,
            WebRequest request
    ){
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),404 );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
