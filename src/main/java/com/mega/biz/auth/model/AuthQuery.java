package com.mega.biz.auth.model;

public enum AuthQuery {
  REFRESH_RENEW_TOKEN_UPDATE("update user3 set refresh=? where email=?"),
  USER_NAME_SELECT("select name from user3 where refresh=?");

  private final String query;

  AuthQuery(String query) {
    this.query = query;
  }

  public String getQuery() {
    return query;
  }
}