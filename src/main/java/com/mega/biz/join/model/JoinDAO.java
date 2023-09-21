package com.mega.biz.join.model;

import com.mega.biz.join.model.dto.UserDTOOriginal;
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

    public UserDTOOriginal findUser(UserDTOOriginal userDTOOriginal) {
        try {
            DataSource dataSource = JDBCUtils.getDataSource();
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(JoinQuery.USER_FIND.getQuery());
            pstmt.setString(1, userDTOOriginal.getEmail());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                UserDTOOriginal findUser = new UserDTOOriginal();
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

//    public int insertUser(UserDTOOriginal userDTOOriginal) {
//
//        int i = 0;
//
//        try {
//            DataSource dataSource = JDBCUtils.getDataSource();
//            conn = dataSource.getConnection();
//            pstmt = conn.prepareStatement(JoinQuery.USER_INSERT.getQuery());
//
//            pstmt.setString(1, userDTOOriginal.getEmail());
//            pstmt.setString(2, userDTOOriginal.getPassword());
//            pstmt.setString(3, userDTOOriginal.getName());
//            pstmt.setString(4, userDTOOriginal.getPhone());
//            pstmt.setLong(5, userDTOOriginal.getUserStatus());
//            pstmt.setString(6, userDTOOriginal.getSalt());
//
//            i = pstmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            // ResultSet이 없을 때 close
//            JDBCUtils.close(conn, pstmt);
//        }
//        return i;
//    }

    public int insertUser(UserDTO userDTO) {

        int i = 0;

        try {
            DataSource dataSource = JDBCUtils.getDataSource();
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(JoinQuery.USER_INSERT.getQuery());

            pstmt.setString(1, userDTO.getEmail());
            pstmt.setString(2, userDTO.getEncrypedPassword());
            pstmt.setString(3, userDTO.getName());
            pstmt.setString(4, userDTO.getPhone());
            pstmt.setLong(5, userDTO.getUserStatus());
            pstmt.setString(6, userDTO.getSalt());

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
