package com.mega.config.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {

    static {
        try {
            Properties props = new Properties();

            // jdbc.properties 파일을 클래스패스에서 읽음
            try (InputStream input = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties")) {
                props.load(input);
                String driverClassName = props.getProperty("jdbc.driver");
                Class.forName(driverClassName); // 드라이버 클래스 로드
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        Properties props = new Properties();

        try (InputStream input = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties")) {
            props.load(input);
            String url = props.getProperty("jdbc.url");
            String user = props.getProperty("jdbc.user");
            String pass = props.getProperty("jdbc.password");

            conn = DriverManager.getConnection(url, user, pass);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void close(Connection conn, PreparedStatement pstmt) {
        try {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 트랜잭션 처리
    public static void commit(Connection conn) {
        try {
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void rollback(Connection conn) {
        try {
            conn.rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
