package com.mega.biz.join.model;

public enum JoinQuery {
    USER_INSERT("insert into user_test values(?, ?, ?, ?, ?, ?)"),
    USER_FIND("select * from user_test where email = ?");

    private final String query;

    JoinQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
