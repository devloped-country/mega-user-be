package com.mega.biz.notice.model;

public enum NoticeQuery {

    NOTICE_LIST(" SELECT * FROM notice ORDER BY createdDate DESC "),
    DETAIL_NOTICE(" SELECT * FROM notice WHERE id=? ");

    private final String query;

    NoticeQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

}
