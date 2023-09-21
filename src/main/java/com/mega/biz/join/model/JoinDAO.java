package com.mega.biz.join.model;

import com.mega.biz.join.model.dto.UserValidationDTO;
import com.mega.biz.join.model.dto.UserDTO;
import com.mega.config.database.JDBCUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JoinDAO {

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public UserDTO findUser(UserDTO userDTO) {
        try {
            DataSource dataSource = JDBCUtils.getDataSource();
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(JoinQuery.USER_FIND.getQuery());
            pstmt.setString(1, userDTO.getEmail());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                UserDTO findUser = new UserDTO();
                findUser.setEmail(rs.getString("email"));
                findUser.setPassword(rs.getString("password"));
                findUser.setName(rs.getString("name"));
                findUser.setPhone(rs.getString("phone"));
                findUser.setUserStatus(rs.getLong("user_status"));
                findUser.setSalt(rs.getString("salt"));

                return findUser;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // ResultSet이 있을 때 close
            JDBCUtils.close(conn, pstmt, rs);
        }
        return null;
    }

    public int insertUser(UserValidationDTO userValidationDTO) {

        int i = 0;

        try {
            DataSource dataSource = JDBCUtils.getDataSource();
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(JoinQuery.USER_INSERT.getQuery());

            pstmt.setString(1, userValidationDTO.getEmail());
            pstmt.setString(2, userValidationDTO.getEncrypedPassword());
            pstmt.setString(3, userValidationDTO.getName());
            pstmt.setString(4, userValidationDTO.getPhone());
            pstmt.setLong(5, userValidationDTO.getUserStatus());
            pstmt.setString(6, userValidationDTO.getSalt());

            i = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // ResultSet이 없을 때 close
            JDBCUtils.close(conn, pstmt);
        }
        return i;
    }
}
