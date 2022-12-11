package org.vuchete.medical.service.exceptions;

public enum ErrorCodes {
  INTERNAL_SERVER_ERROR("BACKEND-2000", "Internal server error");

  private String code;
  private String description;

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
