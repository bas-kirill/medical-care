package ru.tfs.spring.web.exception;

public class CsvParsingException extends RuntimeException {
    public CsvParsingException(String errorMessage) {
        super(errorMessage);
    }
}
