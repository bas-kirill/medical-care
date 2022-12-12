package org.vuchete.qr.code.service.exceptions;

public enum ErrorCodes {
  INTERNAL_SERVER_ERROR("BACKEND-1300", "Internal server error");

  private final String code;
  private final String description;

  ErrorCodes(String code, String description) {
    this.code = code;
    this.description = description;
  }

  public String getCode() {
    return code;
  }

  public String getDescription() {
    return description;
  }
}
