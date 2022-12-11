package org.vuchete.person.service.exceptions;

public class BusinessError {
  public String error;
  public String description;

  public BusinessError(String error, String description) {
    this.error = error;
    this.description = description;
  }
}
