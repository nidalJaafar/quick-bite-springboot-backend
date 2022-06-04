package com.quickbite.backend.common.exception;

import com.quickbite.backend.common.response.ExceptionResponse;
import io.jsonwebtoken.JwtException;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = {
      EntityNotFoundException.class,
      UsernameNotFoundException.class,
      JwtException.class
  })
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ExceptionResponse entityNotFound(Exception e) {
    return
        new ExceptionResponse()
            .setMessage(e.getMessage());
  }

  @ExceptionHandler(value = {AuthenticationException.class})
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  public ExceptionResponse unauthorized(AuthenticationException e) {
    return new ExceptionResponse().setMessage(e.getMessage());
  }

  @ExceptionHandler(value = {AccessDeniedException.class})
  @ResponseStatus(HttpStatus.FORBIDDEN)
  public ExceptionResponse accessDenied(AccessDeniedException e) {
    return new ExceptionResponse().setMessage(e.getMessage());
  }

  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  Map<String, String> onConstraintValidationException(
      ConstraintViolationException e) {
    Map<String, String> error = new HashMap<>();
    e.getConstraintViolations()
        .forEach(constraintViolation -> error.put(
            constraintViolation.getPropertyPath().toString(),
            constraintViolation.getMessage()));
    return error;
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  Map<String, String> onMethodArgumentNotValidException(
      MethodArgumentNotValidException e) {
    Map<String, String> error = new HashMap<>();
    e.getBindingResult().getFieldErrors()
        .forEach(fieldError -> error.put(fieldError.getField(), fieldError.getDefaultMessage()));
    return error;
  }

}
