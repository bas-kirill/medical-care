package org.vuchete.person.service.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {
  private static Logger log = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

  @ExceptionHandler(RuntimeException.class)
  ResponseEntity<BusinessError> onInternalError(RuntimeException e) {
    log.info(e.getMessage());
    return ResponseEntity.internalServerError().body(
        new BusinessError(
            ErrorCodes.INTERNAL_SERVER_ERROR.code,
            ErrorCodes.INTERNAL_SERVER_ERROR.description
        )
    );
  }

  @ExceptionHandler(PersonNotFoundException.class)
  ResponseEntity<BusinessError> onPersonDontExistException(RuntimeException e) {
    log.info(e.getMessage());
    return ResponseEntity.notFound().build();
  }
}
