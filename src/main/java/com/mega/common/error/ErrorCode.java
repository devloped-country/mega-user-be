package com.mega.common.error;

public enum ErrorCode {
  ERROR_CODE_FIRST("-1"),
  ERROR_CODE_SECOND("-2");

  private final String code;

  ErrorCode(String code) {
    this.code = code;
  }

  public String getErrorCode() {
    return this.code;
  }
}
