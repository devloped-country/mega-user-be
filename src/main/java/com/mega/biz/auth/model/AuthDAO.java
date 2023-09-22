package com.mega.biz.auth.model;

import com.mega.config.database.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

public class AuthDAO {
  private Connection conn = null;
  private PreparedStatement pstmt = null;
  private ResultSet rs = null;
  public void updateRefresh(String token, String email) {
    try {
      DataSource dataSource = JDBCUtils.getDataSource();
      conn = dataSource.getConnection();
      pstmt = conn.prepareStatement(AuthQuery.REFRESH_RENEW_TOKEN_UPDATE.getQuery());
      pstmt.setString(1, token);
      pstmt.setString(2, email);
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.close(conn, pstmt, rs);
    }
  }
}
