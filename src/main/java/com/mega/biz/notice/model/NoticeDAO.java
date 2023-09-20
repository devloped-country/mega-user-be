package com.mega.biz.notice.model;

import com.mega.biz.notice.model.dto.NoticeDTO;
import com.mega.config.database.JDBCUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoticeDAO {

    private final DataSource dataSource = JDBCUtils.getDataSource();

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;


    public List<NoticeDTO> getNoticeList() {
        List<NoticeDTO> noticeList = new ArrayList<>();

        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(NoticeQuery.NOTICE_LIST.getQuery());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                NoticeDTO noticeDTO = new NoticeDTO();

                int getTagID = rs.getInt("TAG_ID");
                if (getTagID == 1) {
                    noticeDTO.setTag_id("훈련비");
                } else if (getTagID == 2) {
                    noticeDTO.setTag_id("시험");
                } else if (getTagID == 3) {
                    noticeDTO.setTag_id("BIPA행사관련");
                } else if (getTagID == 4) {
                    noticeDTO.setTag_id("BIPA전달사항");
                } else if (getTagID == 5) {
                    noticeDTO.setTag_id("BIPA채용공지");
                } else if (getTagID == 6) {
                    noticeDTO.setTag_id("세미나");
                } else if (getTagID == 7) {
                    noticeDTO.setTag_id("긴급");
                } else if (getTagID == 8) {
                    noticeDTO.setTag_id("기타");
                }

                noticeDTO.setId(rs.getInt("ID"));
                noticeDTO.setTitle(rs.getString("TITLE"));
                noticeDTO.setContent(rs.getString("CONTENT"));
                noticeDTO.setAuthor(rs.getString("AUTHOR"));
                noticeDTO.setCreatedDate(rs.getString("CREATED_DATE"));

                noticeList.add(noticeDTO);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt, rs);
        }

        return noticeList;
    }

    public NoticeDTO getDetailNotice(int id) {
        NoticeDTO noticeDTO = new NoticeDTO();

        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(NoticeQuery.DETAIL_NOTICE.getQuery());
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {

                noticeDTO.setId(rs.getInt("ID"));
                noticeDTO.setTitle(rs.getString("TITLE"));
                noticeDTO.setContent(rs.getString("CONTENT"));
                noticeDTO.setAuthor(rs.getString("AUTHOR"));
                noticeDTO.setCreatedDate(rs.getString("CREATED_DATE"));
                noticeDTO.setTag_id(rs.getString("TAG_ID"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt);
        }

        return noticeDTO;
    }
}
