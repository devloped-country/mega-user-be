package com.mega.biz.qr.model;

public enum QrQuery {
  ATTENDANCE_STATUS_UPDATE("update attendance set attendance_stat = case when timestampdiff(minute, start_date, end_date) >= 465 then 2 when timestampdiff(minute, start_date, end_date) < 465 THEN 3 when timestampdiff(minute, start_date, end_date) = 0 then 5 else attendance_stat end where email=? and DATE_FORMAT(end_date, '%H:%i:%s') NOT LIKE '00:00:00'"),
  ATTENDANCE_START_DATE_UPDATE("update attendance set start_date=now() where email=? and DATE_FORMAT(start_date, '%Y-%m-%d') LIKE DATE(?) and DATE_FORMAT(start_date, '%H:%i:%s') LIKE '00:00:00'"),
  ATTENDANCE_END_DATE_UPDATE("update attendance set end_date=now() where email=? and DATE_FORMAT(end_date, '%Y-%m-%d') LIKE DATE(?) and DATE_FORMAT(start_date, '%H:%i:%s') NOT LIKE '00:00:00'"),
  ATTENDANCE_STATUS_SELECT("select attendance_stat from attendance where email=? and DATE_FORMAT(end_date, '%Y-%m-%d') LIKE DATE(CURDATE())");

  private final String query;

  QrQuery(String query) {
    this.query = query;
  }

  public String getQuery() {
    return query;
  }
}
