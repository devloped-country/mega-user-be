package com.mega.biz.home.model;

public enum HomeQuery {
  ATTENDANCE_STAT_SELECT("select attendance_stat, DATE_FORMAT(start_date, '%Y-%m-%d') as start_date, name from attendance2 as a inner join user3 as u on a.email = u.email where refresh=? and YEAR(start_date)=? and MONTH(start_date)=? ORDER BY start_date"),
  CURRICULUM_RECENT_SELECT("select id, subject, start_date, end_date from curriculum where end_date >= CURDATE() order by start_date desc limit 5"),
  NOTICE_RECENT_SELECT("select * from notice2 order by created_date desc limit 5"),
  ATTENDANCE_DURATION_SELECT("select duration from attendance_duration"),
  ATTENDANCE_STAT_DURATION_SELECT("select count(attendance_stat) as attendance_count from attendance2 inner join user3 on attendance2.email = user3.email where refresh=? and attendance_stat=? and end_date between ? and ?");

  private final String query;

  HomeQuery(String query) { this.query = query; }

  public String getQuery() {
    return query;
  }
}
