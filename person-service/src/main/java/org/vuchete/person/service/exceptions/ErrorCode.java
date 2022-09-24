package org.vuchete.person.service.exceptions;

import lombok.Getter;

/**
 * See repository root with code description (error-codes.md)
 * TODO: lombok?
 */
@Getter
public enum ErrorCode {
  INTERNAL_SERVER_ERROR("BACKEND-1000", "Internal server error"),
  STUB_ERROR("BACKEND-1100", "some description");

  private final String code;
  private final String description;

  ErrorCode(String value, String description) {
    this.code = value;
    this.description = description;
  }
}
