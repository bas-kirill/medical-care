package org.vuchete.person.service.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Capture and process exceptions.
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {

  @ExceptionHandler(RuntimeException.class)
  ResponseEntity<Error> onInternalError(RuntimeException e) {
    log.error(e.getMessage());
    return createErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ErrorCode.INTERNAL_SERVER_ERROR);
  }

  private ResponseEntity<Error> createErrorResponse(HttpStatus httpStatus, ErrorCode errorCode) {
    BodyBuilder response = ResponseEntity.status(httpStatus);
    return response.body(new Error(errorCode.getCode(), errorCode.getDescription()));
  }

}
