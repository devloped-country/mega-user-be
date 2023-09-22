package com.mega.biz.login.model;

import com.mega.biz.login.model.dto.AuthDTO;
import com.mega.biz.login.model.dto.LoginDTO;
import com.mega.biz.login.model.dto.TokenDTO;
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
        dto.setName(rs.getString("name"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.close(conn, pstmt, rs);
    }

    return dto;
  }

  public void updateRefresh(LoginDTO loginDTO, AuthDTO authDTO) {
    try {
      DataSource dataSource = JDBCUtils.getDataSource();
      conn = dataSource.getConnection();
      pstmt = conn.prepareStatement(LoginQuery.REFRESH_TOKEN_UPDATE.getQuery());
      pstmt.setString(1, authDTO.getRefreshToken());
      pstmt.setString(2, loginDTO.getEmail());
      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.close(conn, pstmt, rs);
    }
  }
}
