package com.mega.biz.join.service;

import com.mega.biz.join.model.dto.UserDTO;
import com.mega.biz.join.model.dto.UserDTOv;
import com.mega.common.encrypt.EncryptUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JoinServiceTest {

    JoinService service = new JoinService();
    EncryptUtils encryptUtils = new EncryptUtils();

    @Test
    void test01() {
        UserDTO userDTO = new UserDTO("dcwang2@naver.com", "1234", "찬현", "01000000000", 1L, "1234");

        boolean i = service.saveUser(userDTO);
        System.out.println("i = " + i);
    }

    @Test
    void insertOne() {
        UserDTO userDTO = new UserDTO("test@naver.com", "1234", "테스트", "01012345678", 1L, null);
        boolean b = service.saveUser(userDTO);
    }

    @Test
    void insertMany() {
        for (int i = 1; i < 22; i++) {
            UserDTO userDTO = new UserDTO("test" + i + "@naver.com", "1234", "테스트" + i, "01012345678", 1L, null);
            service.saveUser(userDTO);
        }
    }

    @Test
    void insertV2() {
        UserDTOv userDTOv = new UserDTOv();
        userDTOv.setEmail("aaaa@naver.com");
        userDTOv.setPassword("Cksgus892201*");
        userDTOv.setName("테스트");
        userDTOv.setPhone("01055933522");

        service.saveUser2(userDTOv);
    }

}