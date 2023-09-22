package com.mega.biz.login.exception;

public class TokenException extends RuntimeException {
  public TokenException() {}

  public TokenException(String message) { super(message); }
}
