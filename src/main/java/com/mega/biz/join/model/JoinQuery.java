package com.mega.biz.join.model;

public enum JoinQuery {
    USER_INSERT("insert into user3 (email, password, name, phone, user_status, salt) values(?, ?, ?, ?, ?, ?)"),
    USER_FIND("select * from user3 where email = ?"),
    INSERT_ATTENDANCE("insert into attendance2 (attendance_stat, start_date, end_date, email) values (1, TIMESTAMP(CURDATE(), MAKETIME(0,0,0)), TIMESTAMP(CURDATE(), MAKETIME(0,0,0)), ?)");

    private final String query;

    JoinQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
