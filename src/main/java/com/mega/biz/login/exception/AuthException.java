package com.mega.biz.login.exception;

public class AuthException extends RuntimeException {
  public AuthException() {}

  public AuthException(String message) {
    super(message);
  }
}