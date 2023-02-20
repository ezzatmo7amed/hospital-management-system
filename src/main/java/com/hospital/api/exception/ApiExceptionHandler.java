package com.hospital.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;


@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<Object> handleApiRequestException(NotFoundException eX){
        // 1- Create Payload Containing Exception Details
        HttpStatus badRequest = HttpStatus.NOT_FOUND;
        ApiExceptionDetails exceptionDetails = new ApiExceptionDetails(
                eX.getMessage(),
                badRequest,
                ZonedDateTime.now()
        );
        // 2- Return Response Entity
        return new ResponseEntity<>(exceptionDetails, badRequest);

    }

    @ExceptionHandler(value = {ResourceExists.class})
    public ResponseEntity<Object> handleRequestException(ResourceExists eX){
        HttpStatus badRequest = HttpStatus.IM_USED;
        ApiExceptionDetails exceptionDetails = new ApiExceptionDetails(
                eX.getMessage(),
                badRequest,
                ZonedDateTime.now()
        );
        // 2- Return Response Entity
        return new ResponseEntity<>(exceptionDetails, badRequest);
    }
}
