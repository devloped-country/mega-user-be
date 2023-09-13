package com.mega.model.sample;

import com.mega.model.sample.dto.SampleDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SampleDAO2Test {

    SampleDAO2 dao = new SampleDAO2();

    @Test
    void test01() {
        List<SampleDTO> userList = dao.getUserList();
        for (SampleDTO sampleDTO : userList) {
            System.out.println("sampleDTO = " + sampleDTO);
        }
    }

    @Test
    void test02() {

        SampleDTO dto = new SampleDTO("test10", "1234", "테스트10", "USER");

        dao.insertUser(dto);

    }

}