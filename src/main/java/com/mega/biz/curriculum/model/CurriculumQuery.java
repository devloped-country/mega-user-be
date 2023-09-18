package com.mega.biz.curriculum.model;

public enum CurriculumQuery {

    CURRICULUM_LIST("select * from curriculum order by START_DATE"),
    DETAIL_LIST_BY_CURRICULUM_ID("select * from detail_subject where curriculum_id = ?");

    private final String query;

    CurriculumQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
