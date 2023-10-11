package com.mega.biz.home.model;

import com.mega.biz.home.model.dto.HomeAttendanceDTO;
import com.mega.biz.home.model.dto.HomeCurriculumDTO;
import com.mega.biz.home.model.dto.HomeNoticeDTO;
import com.mega.biz.home.model.dto.HomeProfileDTO;
import com.mega.config.database.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import javax.sql.DataSource;

public class HomeDAO {

  private final DataSource dataSource = JDBCUtils.getDataSource();

  private Connection conn = null;
  private PreparedStatement pstmt = null;
  private ResultSet rs = null;

  public ArrayList<HomeAttendanceDTO> selectAttendnaceStat(String token, String year, String month) {
    ArrayList<HomeAttendanceDTO> homeAttendanceListDTO = new ArrayList<>();

    try {
      conn = dataSource.getConnection();
      pstmt = conn.prepareStatement(HomeQuery.ATTENDANCE_STAT_SELECT.getQuery());
      pstmt.setString(1, token);
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

  public ArrayList<HomeCurriculumDTO> selectRecentCurriculum() {
    ArrayList<HomeCurriculumDTO> homeCurriculumListDTO = new ArrayList<>();

    try {
      conn = dataSource.getConnection();
      pstmt = conn.prepareStatement(HomeQuery.CURRICULUM_RECENT_SELECT.getQuery());
      rs = pstmt.executeQuery();

      while(rs.next()) {
        HomeCurriculumDTO homeCurriculumDTO = new HomeCurriculumDTO();

        homeCurriculumDTO.setId(rs.getInt("id"));
        homeCurriculumDTO.setSubject(rs.getString("subject"));
        homeCurriculumDTO.setStartDate(rs.getTimestamp("start_date"));
        homeCurriculumDTO.setEndDate(rs.getTimestamp("end_date"));

        homeCurriculumListDTO.add(homeCurriculumDTO);
      }
    } catch(SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.close(conn, pstmt, rs);
    }

    return homeCurriculumListDTO;
  }

  public ArrayList<HomeNoticeDTO> selectRecentNotice() {
    ArrayList<HomeNoticeDTO> homeNoticeListDTO = new ArrayList<>();

    try {
      conn = dataSource.getConnection();
      pstmt = conn.prepareStatement(HomeQuery.NOTICE_RECENT_SELECT.getQuery());
      rs = pstmt.executeQuery();

      while(rs.next()) {
        HomeNoticeDTO homeNoticeDTO = new HomeNoticeDTO();

        homeNoticeDTO.setId(rs.getInt("id"));
        homeNoticeDTO.setTagId(rs.getInt("tag_id"));
        homeNoticeDTO.setAuthor(rs.getString("author"));
        homeNoticeDTO.setCreatedDate(rs.getTimestamp("created_date"));
        homeNoticeDTO.setTitle(rs.getString("title"));

        homeNoticeListDTO.add(homeNoticeDTO);
      }
    } catch(SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.close(conn, pstmt, rs);
    }

    return homeNoticeListDTO;
  }

  public int selectDuration() {
    int duration = 0;

    try {
      conn  = dataSource.getConnection();
      pstmt = conn.prepareStatement(HomeQuery.ATTENDANCE_DURATION_SELECT.getQuery());
      rs = pstmt.executeQuery();

      if(rs.next()) {
        duration = rs.getInt("duration");
      }
    } catch(SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.close(conn, pstmt, rs);
    }

    return duration;
  }

  public ArrayList<HomeProfileDTO> selectProfileAttendance(String token, int duration) {
    ArrayList<HomeProfileDTO> homeProfileListDTO = new ArrayList<>();

    for(int i=2; i<8; i++) {
      try {
        HomeProfileDTO homeProfileDTO = new HomeProfileDTO();

        conn = dataSource.getConnection();
        pstmt = conn.prepareStatement(HomeQuery.ATTENDANCE_STAT_DURATION_SELECT.getQuery());
        pstmt.setString(1, token);
        pstmt.setInt(2, i);


        int startDuration;
        if(duration + 1 > YearMonth.of(LocalDate.now().getYear(), LocalDate.now().getMonth().minus(1)).lengthOfMonth()) {
          startDuration = 1;
        } else {
          startDuration = duration + 1;
        }

        pstmt.setString(3, String.valueOf(
            LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth().minus(1), startDuration  )));
        pstmt.setString(4, String.valueOf(LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), duration)));
        rs = pstmt.executeQuery();

        if (rs.next()) {
            homeProfileDTO.setAttendanceCount(rs.getInt("attendance_count"));
        }

        homeProfileListDTO.add(homeProfileDTO);
      } catch (SQLException e) {
        e.printStackTrace();
      } finally {
        JDBCUtils.close(conn, pstmt, rs);
      }
    }

    return homeProfileListDTO;
  }
}
