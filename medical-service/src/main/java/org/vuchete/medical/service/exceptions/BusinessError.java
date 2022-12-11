package org.vuchete.medical.service.exceptions;

public class BusinessError {
  private String code;
  private String description;

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
