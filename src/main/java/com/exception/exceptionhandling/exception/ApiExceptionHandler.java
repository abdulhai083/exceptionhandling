package com.exception.exceptionhandling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;


// this class will act as a central place to handle exception for entire application
@RestControllerAdvice
public class ApiExceptionHandler {

    // in entire program,
    // anywhere if apiException occurs then below method
    // will be executed. This is done using @Exception

    @ExceptionHandler(ApiException.class) // we can pass more than one exception classes here like RunTimeException, IllegalStateException, etc.
    public ResponseEntity<Object> handleApiException(ApiException apiException){

        // create payload containing exception details
        ApiExceptionPayLoad apiExceptionPayLoad = new ApiExceptionPayLoad(
                apiException.getMessage(),
                apiException, // throwable -> actual exception
                HttpStatus.BAD_GATEWAY, // Https Error code
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        // return response entity with payload
        return new ResponseEntity<>(apiExceptionPayLoad,HttpStatus.BAD_GATEWAY);


    }
}
