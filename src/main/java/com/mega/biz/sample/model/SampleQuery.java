package com.mega.biz.sample.model;

public enum SampleQuery {

    USER_LIST("select * from users_test"),
    USER_INSERT("insert into users_test values(?, ?, ?, ?)");

    private final String query;

    SampleQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
