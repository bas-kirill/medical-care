package org.vuchete.person.service.exceptions;

import java.util.logging.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {
  private static Logger LOG = Logger.getLogger(ExceptionControllerAdvice.class.getName());

  @ExceptionHandler(RuntimeException.class)
  ResponseEntity<BusinessError> onInternalError(RuntimeException e) {
    LOG.info(e.getMessage());
    return ResponseEntity.internalServerError().body(
        new BusinessError(
            ErrorCodes.INTERNAL_SERVER_ERROR.code,
            ErrorCodes.INTERNAL_SERVER_ERROR.description
        )
    );
  }

  @ExceptionHandler(PersonNotFoundException.class)
  ResponseEntity<BusinessError> onPersonDontExistException(RuntimeException e) {
    LOG.info(e.getMessage());
    return ResponseEntity.notFound().build();
  }
}
