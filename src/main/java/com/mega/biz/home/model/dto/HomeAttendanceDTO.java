package com.mega.biz.home.model.dto;

import java.util.Date;

public class HomeAttendanceDTO {
  private Date startDate;
  private int stat;

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public int getStat() {
    return stat;
  }

  public void setStat(int stat) {
    this.stat = stat;
  }
}
