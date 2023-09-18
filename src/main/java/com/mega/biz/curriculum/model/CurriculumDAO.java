package com.mega.biz.curriculum.model;

import com.mega.biz.curriculum.model.dto.CurriculumWithDetailDTO;
import com.mega.biz.curriculum.model.dto.DetailSubjectDTO;
import com.mega.config.database.JDBCUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CurriculumDAO {

    private final DataSource dataSource = JDBCUtils.getDataSource();

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public List<DetailSubjectDTO> getDetailListByCurriculumId(Long curriculumId) {
        List<DetailSubjectDTO> detailList = new ArrayList<>();

        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(CurriculumQuery.DETAIL_LIST_BY_CURRICULUM_ID.getQuery());
            pstmt.setLong(1, curriculumId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                DetailSubjectDTO detail = new DetailSubjectDTO();

                detail.setId(rs.getLong("ID"));
                detail.setCurriculumId(rs.getLong("CURRICULUM_ID"));
                detail.setContent(rs.getString("CONTENT"));
                detailList.add(detail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt, rs);
        }

        return detailList;
    }

    public List<CurriculumWithDetailDTO> getAllCurriculum() {
        List<CurriculumWithDetailDTO> curriculumDTOList = new ArrayList<>();

        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(CurriculumQuery.CURRICULUM_LIST.getQuery());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                CurriculumWithDetailDTO curriculumDTO = new CurriculumWithDetailDTO();

                curriculumDTO.setId(rs.getLong("ID"));
                curriculumDTO.setSubject(rs.getString("SUBJECT"));
                curriculumDTO.setTime(rs.getInt("TIME"));
                curriculumDTO.setStartDate(rs.getDate("START_DATE").toLocalDate());
                curriculumDTO.setEndDate(rs.getDate("END_DATE").toLocalDate());

                curriculumDTOList.add(curriculumDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt, rs);
        }
        return curriculumDTOList;
    }
}
