package com.mega.biz.qr.model.dto;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class QrDTO {
  private String qr;
  private String email;
  private Timestamp date;
  private int status;

  public QrDTO() {}

  public QrDTO(String qr, String email) {
    this.qr = qr;
    this.email = email;
    this.date = Timestamp.valueOf(LocalDateTime.now());
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getQr() {
    return qr;
  }

  public void setQr(String qr) {
    this.qr = qr;
  }

  public Timestamp getDate() {
    return date;
  }

  public void setDate(Timestamp date) {
    this.date = date;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }
}
