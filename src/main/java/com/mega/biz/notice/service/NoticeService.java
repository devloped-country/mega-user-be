package com.mega.biz.notice.service;

import com.mega.biz.notice.model.NoticeDAO;
import com.mega.biz.notice.model.dto.NoticeDTO;

import java.util.List;

public class NoticeService {

    private final NoticeDAO dao = new NoticeDAO();

    public List<NoticeDTO> getNoticeList() { return dao.getNoticeList(); }

    public NoticeDTO getDetailList(int id) { return dao.getDetailNotice(id); }
}
