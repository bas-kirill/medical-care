package org.vuchete.person.service.exceptions;

public final class BusinessError {
  public final String error;
  public final String description;

  public BusinessError(String error, String description) {
    this.error = error;
    this.description = description;
  }
}
