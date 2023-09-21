package com.mega.biz.login.model;

public enum LoginQuery {
  LOGIN_INFO_SELECT("select email, password, salt, name from user3 where email=?"),
  REFRESH_TOKEN_UPDATE("update user3 set refresh=? where email=?"),
  REFRESH_TOKEN_SELECT("select refresh from user3 where email=?"),
  REFRESH_RENEW_TOKEN_UPDATE("update user3 set refresh=? where email=?");

  private final String query;

  LoginQuery(String query) {
    this.query = query;
  }

  public String getQuery() {
    return query;
  }
}
