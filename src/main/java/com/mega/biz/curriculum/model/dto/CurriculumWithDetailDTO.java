package com.mega.biz.curriculum.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CurriculumWithDetailDTO {

    private Long id;
    private String subject;
    private int time;
    private LocalDate startDate;
    private LocalDate endDate;
    private String startDateString;
    private String endDateString;

    private List<DetailSubjectDTO> detailSubjectDTOList = new ArrayList<>();

    public CurriculumWithDetailDTO(String subject, int time, Date startDate, Date endDate) {
        this.subject = subject;
        this.time = time;
        this.startDate = startDate.toLocalDate();
        this.endDate = endDate.toLocalDate();
    }

    public void setStartDate(LocalDate startDate) {
        this.startDateString = String.format("%02d.%02d.%02d", startDate.getYear() % 100, startDate.getMonthValue(), startDate.getDayOfMonth());
    }

    public void setEndDate(LocalDate endDate) {
        this.endDateString = String.format("%02d.%02d.%02d", endDate.getYear() % 100, endDate.getMonthValue(), endDate.getDayOfMonth());
    }

}
