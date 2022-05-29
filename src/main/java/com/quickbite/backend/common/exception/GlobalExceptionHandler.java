package com.quickbite.backend.common.exception;

import com.quickbite.backend.common.response.ExceptionResponse;
import io.jsonwebtoken.JwtException;
import javax.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = {
      EntityNotFoundException.class,
      UsernameNotFoundException.class,
      JwtException.class
  })
  public ResponseEntity<ExceptionResponse> entityNotFound(Exception e) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(
            new ExceptionResponse()
                .setMessage(e.getMessage())
        );
  }
}
