package com.mega.biz.login.model;

public enum LoginQuery {
  LOGIN_INFO_SELECT("select password, salt from user where email=?");

  private final String query;

  LoginQuery(String query) {
    this.query = query;
  }

  public String getQuery() {
    return query;
  }
}
