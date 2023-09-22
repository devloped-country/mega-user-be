package com.mega.biz.auth.model;

public enum AuthQuery {
  REFRESH_RENEW_TOKEN_UPDATE("update user3 set refresh=? where email=?");

  private final String query;

  AuthQuery(String query) {
    this.query = query;
  }

  public String getQuery() {
    return query;
  }
}