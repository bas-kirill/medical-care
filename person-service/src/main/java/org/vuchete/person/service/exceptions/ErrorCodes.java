package org.vuchete.person.service.exceptions;

public enum ErrorCodes {
  INTERNAL_SERVER_ERROR("BACKEND-1000", "Internal server error");

  public final String code;
  public final String description;

  ErrorCodes(String code, String description) {
    this.code = code;
    this.description = description;
  }
}
