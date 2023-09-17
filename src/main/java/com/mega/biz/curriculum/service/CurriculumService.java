package com.mega.biz.curriculum.service;

import com.mega.biz.curriculum.model.CurriculumDAO;
import com.mega.biz.curriculum.model.dto.CurriculumWithDetailDTO;
import com.mega.biz.curriculum.model.dto.DetailSubjectDTO;

import java.util.List;

public class CurriculumService {

    private final CurriculumDAO dao = new CurriculumDAO();

    public List<CurriculumWithDetailDTO> getAllCurriculumWithDetail() {

        List<CurriculumWithDetailDTO> allCurriculum = dao.getAllCurriculum();

        for (CurriculumWithDetailDTO curriculumWithDetailDTO : allCurriculum) {
            List<DetailSubjectDTO> detailsByCurriculumId = dao.getDetailListByCurriculumId(curriculumWithDetailDTO.getId());
            for (DetailSubjectDTO detailSubjectDTO : detailsByCurriculumId) {
                curriculumWithDetailDTO.getDetailSubjectDTOList().add(detailSubjectDTO);
            }
        }

        return allCurriculum;
    }
}
