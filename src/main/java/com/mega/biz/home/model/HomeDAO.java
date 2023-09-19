package com.mega.biz.home.model;

import com.mega.biz.home.model.dto.HomeAttendanceDTO;
import com.mega.config.database.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;

public class HomeDAO {

  private final DataSource dataSource = JDBCUtils.getDataSource();

  private Connection conn = null;
  private PreparedStatement pstmt = null;
  private ResultSet rs = null;

  public ArrayList<HomeAttendanceDTO> selectAttendnaceStat(String name, String year, String month) {
    ArrayList<HomeAttendanceDTO> homeAttendanceListDTO = new ArrayList<>();

    try {
      conn = dataSource.getConnection();
      pstmt = conn.prepareStatement(HomeQuery.ATTENDANCE_STAT_SELECT.getQuery());
      pstmt.setString(1, name);
      pstmt.setString(2, year);
      pstmt.setString(3, month);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        HomeAttendanceDTO homeAttendanceDTO = new HomeAttendanceDTO();
        homeAttendanceDTO.setStartDate(rs.getTimestamp("start_date"));
        homeAttendanceDTO.setStat(rs.getInt("attendance_stat"));

        homeAttendanceListDTO.add(homeAttendanceDTO);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.close(conn, pstmt, rs);
    }

    return homeAttendanceListDTO;
  }
}
