package com.mega.biz.qr.model;

import com.mega.biz.qr.model.dto.QrDTO;
import com.mega.config.database.JDBCUtils;
import com.mega.config.database.JedisUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

public class QrDAO {

  private Connection conn = null;
  private PreparedStatement pstmt = null;
  private ResultSet rs = null;

  public QrDTO selectQr() {
    QrDTO dto = new QrDTO();

    try {
      JedisUtils.connect();
      dto.setQr(JedisUtils.getJedis().get("qr"));
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      JedisUtils.close();
    }

    return dto;
  }

  public void updateAttendanceStatus(QrDTO qrDTO) {
    try {
      DataSource dataSource = JDBCUtils.getDataSource();
      conn = dataSource.getConnection();
      pstmt = conn.prepareStatement(QrQuery.ATTENDANCE_STATUS_UPDATE.getQuery());
      pstmt.setString(1, qrDTO.getEmail());

      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.close(conn, pstmt);
    }
  }

  public void updateAttendanceStartDate(QrDTO qrDTO) {
    try {
      DataSource dataSource = JDBCUtils.getDataSource();
      conn = dataSource.getConnection();
      pstmt = conn.prepareStatement(QrQuery.ATTENDANCE_START_DATE_UPDATE.getQuery());
      pstmt.setString(1, qrDTO.getEmail());
      pstmt.setString(2, qrDTO.getDate().toString());

      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.close(conn, pstmt);
    }
  }

  public void updateAttendanceEndDate(QrDTO qrDTO) {
    try {
      DataSource dataSource = JDBCUtils.getDataSource();
      conn = dataSource.getConnection();
      pstmt = conn.prepareStatement(QrQuery.ATTENDANCE_END_DATE_UPDATE.getQuery());
      pstmt.setString(1, qrDTO.getEmail());
      pstmt.setString(2, qrDTO.getDate().toString());

      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.close(conn, pstmt);
    }
  }

  public QrDTO selectAttendanceStatus(QrDTO qrDTO) {
    QrDTO dto = new QrDTO();

    try {
      DataSource dataSource = JDBCUtils.getDataSource();
      conn = dataSource.getConnection();
      pstmt = conn.prepareStatement(QrQuery.ATTENDANCE_STATUS_SELECT.getQuery());
      pstmt.setString(1, qrDTO.getEmail());

      rs = pstmt.executeQuery();

      if(rs.next()) {
        dto.setStatus(rs.getInt("attendance_stat"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.close(conn, pstmt);
    }

    return dto;
  }
}
