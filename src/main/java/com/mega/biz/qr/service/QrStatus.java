package com.mega.biz.qr.service;

public enum QrStatus {
  QR_STATUS_NOT_ATTENDANCE(1),
  QR_STATUS_ATTENDANCE(2),
  QR_STATUS_LATE(3),
  QR_STATUS_EARLY_LEAVE(4),
  QR_STATUS_ABSENT(5),
  QR_STATUS_OFFICIAL_LEAVE(6),
  QR_STATUS_SICK_LEAVE(7);


  private final int status;

  QrStatus(int status) {
    this.status = status;
  }

  public int getStatus() { return this.status; }
}
