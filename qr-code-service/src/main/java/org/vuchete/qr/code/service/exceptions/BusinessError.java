package org.vuchete.qr.code.service.exceptions;

public final class BusinessError {
  private final String code;
  private final String description;

  public BusinessError(String code, String description) {
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
