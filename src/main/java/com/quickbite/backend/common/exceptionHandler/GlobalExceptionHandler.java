package com.quickbite.backend.common.exceptionHandler;

import com.quickbite.backend.common.response.ExceptionResponse;
import javax.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = EntityNotFoundException.class)
  public ResponseEntity<ExceptionResponse> entityNotFound() {
    ExceptionResponse exceptionResponse = new ExceptionResponse();
    exceptionResponse.setMessage("not Found");
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(exceptionResponse);
  }
}
