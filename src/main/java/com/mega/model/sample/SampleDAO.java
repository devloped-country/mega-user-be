package com.mega.model.sample;

import com.mega.model.JDBCUtils;
import com.mega.model.sample.dto.SampleDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SampleDAO {

//    private final String USER_LIST = "select * from users";
//    private final String USER_INSERT = "insert into users values(?, ?, ?, ?)";

    public void insertUser(SampleDTO sampleDTO) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JDBCUtils.getConnection();
//            pstmt = conn.prepareStatement(USER_INSERT);
            pstmt = conn.prepareStatement(SampleQuery.USER_INSERT.getQuery());
            pstmt.setString(1, sampleDTO.getId());
            pstmt.setString(2, sampleDTO.getPassword());
            pstmt.setString(3, sampleDTO.getName());
            pstmt.setString(4, sampleDTO.getRole());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // ResultSet이 없을 때 close
            JDBCUtils.close(conn, pstmt);
        }
    }

    public List<SampleDTO> getUserList() {
        List<SampleDTO> userList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
//            pstmt = conn.prepareStatement(USER_LIST);
            pstmt = conn.prepareStatement(SampleQuery.USER_LIST.getQuery());
            rs = pstmt.executeQuery();

            while (rs.next()) {

                SampleDTO user = new SampleDTO();
                user.setId(rs.getString("ID"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setName(rs.getString("NAME"));
                user.setRole(rs.getString("ROLE"));

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // ResultSet이 있을 때 close
            JDBCUtils.close(conn, pstmt, rs);
        }
        return userList;
    }
}
