package com.mega.biz.join.model;

public enum JoinQuery {
    USER_INSERT("insert into user1 values(?, ?, ?, ?, ?, ?)"),
    USER_FIND("select * from user1 where email = ?");

    private final String query;

    JoinQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
