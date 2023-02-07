package ru.tfs.spring.data.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.NonUniqueResultException;

@ControllerAdvice
public class CommonExceptionAdvice {

    @ExceptionHandler({NonUniqueResultException.class})
    public ResponseEntity<String> error(NonUniqueResultException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Query did not return a unique result");
    }
}
