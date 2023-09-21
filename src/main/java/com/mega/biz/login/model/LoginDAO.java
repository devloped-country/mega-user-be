package com.mega.biz.login.model;

import com.mega.biz.login.model.dto.LoginDTO;
import com.mega.config.database.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

public class LoginDAO {
  private Connection conn = null;
  private PreparedStatement pstmt = null;
  private ResultSet rs = null;
  public LoginDTO selectAuth(LoginDTO loginDTO) {
    LoginDTO dto = new LoginDTO();

    try {
      DataSource dataSource = JDBCUtils.getDataSource();
      conn = dataSource.getConnection();
      pstmt = conn.prepareStatement(LoginQuery.LOGIN_INFO_SELECT.getQuery());

      pstmt.setString(1, loginDTO.getEmail());
      rs = pstmt.executeQuery();

      if(rs.next()) {
        dto.setEmail(rs.getString("email"));
        dto.setPassword(rs.getString("password"));
        dto.setSalt(rs.getString("salt"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.close(conn, pstmt, rs);
    }

    return dto;
  }

  public LoginDTO selectPassword(LoginDTO loginDTO) {
    try {
      DataSource dataSource = JDBCUtils.getDataSource();
      conn = dataSource.getConnection();
      pstmt = conn.prepareStatement(LoginQuery.LOGIN_INFO_SELECT.getQuery());

      pstmt.setString(1, loginDTO.getEmail());
      rs = pstmt.executeQuery();

      if(rs.next()) {
        loginDTO.setSalt(rs.getString("email"));
        loginDTO.setSalt(rs.getString("salt"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.close(conn, pstmt, rs);
    }

    return loginDTO;
  }
}
