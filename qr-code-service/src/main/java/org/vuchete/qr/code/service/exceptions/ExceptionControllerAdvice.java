package org.vuchete.qr.code.service.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<BusinessError> onInternalError(RuntimeException e) {
    return ResponseEntity.internalServerError().body(
        new BusinessError(
            ErrorCodes.INTERNAL_SERVER_ERROR.getCode(),
            ErrorCodes.INTERNAL_SERVER_ERROR.getDescription()
        )
    );
  }
}
