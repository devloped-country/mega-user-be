package com.mega.service.sample;

import com.mega.model.sample.SampleDAO;
import com.mega.model.sample.SampleDAO2;
import com.mega.model.sample.dto.SampleDTO;

import java.util.List;

public class SampleService {

    private final SampleDAO2 dao = new SampleDAO2();

    public List<SampleDTO> getUserList() {
        List<SampleDTO> userList = dao.getUserList();
        return userList;
    }

    public void insertUser(SampleDTO sampleDTO) {
        dao.insertUser(sampleDTO);
    }
}
