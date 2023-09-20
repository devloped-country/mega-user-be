package com.mega.biz.home.model;

public enum HomeQuery {
  ATTENDANCE_STAT_SELECT("select attendance_stat, DATE_FORMAT(start_date, '%Y-%m-%d') as start_date, name from attendance as a inner join user as u on a.email = u.email where name=? and YEAR(start_date)=? and MONTH(start_date)=? ORDER BY start_date"),
  CURRICULUM_RECENT_SELECT("select id, subject, start_date, end_date from curriculum where END_DATE >= CURDATE() order by start_date desc limit 5"),
  NOTICE_RECENT_SELECT("select * from notice order by created_date desc limit 5"),
  ATTENDANCE_DURATION_SELECT("select duration from attendance_duration"),
  ATTENDANCE_STAT_DURATION_SELECT("select count(attendance_stat) as attendance_count from attendance inner join user on attendance.email = user.email where name=? and attendance_stat=? and end_date between ? and CURDATE()");

  private final String query;

  HomeQuery(String query) { this.query = query; }

  public String getQuery() {
    return query;
  }
}
