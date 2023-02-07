package ru.tfs.spring.web.advice;

import org.springframework.cloud.client.circuitbreaker.NoFallbackAvailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.tfs.spring.web.exception.CsvParsingException;

@ControllerAdvice
public class ParseCsvExceptionAdvice {

    @ExceptionHandler({CsvParsingException.class})
    public ResponseEntity<String> error(CsvParsingException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

    @ExceptionHandler({NoFallbackAvailableException.class})
    public ResponseEntity<String> error(NoFallbackAvailableException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Person service error");
    }
}
