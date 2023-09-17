package com.mega.biz.qr.service;

import com.mega.biz.qr.exception.QrException;
import com.mega.biz.qr.exception.ReAuthException;
import com.mega.biz.qr.model.QrDAO;
import com.mega.biz.qr.model.dto.QrDTO;

public class QrService {

  private final QrDAO dao = new QrDAO();

  public QrDTO authQr(QrDTO qrDTO) throws ReAuthException, QrException {
    String redisQr = dao.selectQr().getQr();

    if (!qrDTO.getQr().equals(redisQr)) {
      throw new QrException();
    }

    QrDTO dto = dao.selectAttendanceStatus(qrDTO);
    if(dto.getStatus() != QrStatus.QR_STATUS_NOT_ATTENDANCE.getStatus()) {
      throw new ReAuthException();
    }

    dao.updateAttendanceEndDate(qrDTO);
    dao.updateAttendanceStatus(qrDTO);
    dao.updateAttendanceStartDate(qrDTO);

    return qrDTO;
  }
}
