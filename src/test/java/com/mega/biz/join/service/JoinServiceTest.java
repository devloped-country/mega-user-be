package com.mega.biz.join.service;

import com.mega.biz.join.model.dto.UserDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JoinServiceTest {

    JoinService service = new JoinService();

    @Test
    void test01() {
        UserDTO userDTO = new UserDTO("dcwang2@naver.com", "1234", "찬현", "01000000000", 1L, "1234");

        boolean i = service.insertUser(userDTO);
        System.out.println("i = " + i);
    }

}