package com.mega.biz.sample.service;

import com.mega.biz.sample.model.SampleDAO;
import com.mega.biz.sample.model.SampleDAO2;
import com.mega.biz.sample.model.dto.SampleDTO;

import java.util.List;

public class SampleService {

    private final SampleDAO dao = new SampleDAO();

    public List<SampleDTO> getUserList() {
        List<SampleDTO> userList = dao.getUserList();
        return userList;
    }

    public void insertUser(SampleDTO sampleDTO) {
        dao.insertUser(sampleDTO);
    }
}
