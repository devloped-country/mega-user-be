package com.mega.biz.join.model;

public enum JoinQuery {
    USER_INSERT("insert into user1 values(?, ?, ?, ?, ?, ?)"),
    USER_FIND("select * from user1 where email = ?"),

    INSERT_ATTENDANCE("insert into attendance1 (attendance_stat, start_date, end_date, email) values (1, now(), now(), ?)");

    private final String query;

    JoinQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
