package com.mega.biz.home.model;

public enum HomeQuery {
  ATTENDANCE_STAT_SELECT("select attendance_stat, start_date, name from attendance as a inner join user as u on a.email = u.email where name=? ORDER BY start_date");

  private final String query;

  HomeQuery(String query) { this.query = query; }

  public String getQuery() {
    return query;
  }
}
