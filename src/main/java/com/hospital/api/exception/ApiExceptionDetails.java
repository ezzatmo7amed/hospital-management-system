package com.hospital.api.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import java.time.ZonedDateTime;


public record ApiExceptionDetails(String message, HttpStatus httpStatus,
                                  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") ZonedDateTime timeStamp) {
    public ApiExceptionDetails(String message, HttpStatus httpStatus, ZonedDateTime timeStamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timeStamp = timeStamp;
    }
}
