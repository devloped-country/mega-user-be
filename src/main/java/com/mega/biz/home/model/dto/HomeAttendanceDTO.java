package com.mega.biz.home.model.dto;

import java.sql.Timestamp;
import java.util.Date;

public class HomeAttendanceDTO {
  private Timestamp startDate;
  private int stat;

  public Timestamp getStartDate() {
    return startDate;
  }

  public void setStartDate(Timestamp startDate) {
    this.startDate = startDate;
  }

  public int getStat() {
    return stat;
  }

  public void setStat(int stat) {
    this.stat = stat;
  }
}
