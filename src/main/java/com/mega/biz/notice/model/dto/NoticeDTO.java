package com.mega.biz.notice.model.dto;

import lombok.*;

@Data
public class NoticeDTO {

    private String id;
    private String tag_id;
    private String title;
    private String content;
    private String author;
    private String createdDate;

}
