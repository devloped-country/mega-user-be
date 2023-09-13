package com.mega.biz.sample.model;

import com.mega.biz.sample.model.dto.SampleDTO;
import com.mega.config.database.JDBCUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SampleDAO {

    private final DataSource dataSource = JDBCUtils.getDataSource();

    public void insertUser(SampleDTO sampleDTO) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SampleQuery.USER_INSERT.getQuery())) {

            pstmt.setString(1, sampleDTO.getId());
            pstmt.setString(2, sampleDTO.getPassword());
            pstmt.setString(3, sampleDTO.getName());
            pstmt.setString(4, sampleDTO.getRole());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<SampleDTO> getUserList() {
        List<SampleDTO> userList = new ArrayList<>();

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SampleQuery.USER_LIST.getQuery());
                ResultSet rs = pstmt.executeQuery()) {

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
        }
        return userList;
    }
}
