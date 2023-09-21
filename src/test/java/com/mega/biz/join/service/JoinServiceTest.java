package com.mega.biz.join.service;

import com.mega.biz.join.model.dto.UserDTO;
import com.mega.common.encrypt.EncryptUtils;
import org.junit.jupiter.api.Test;

class JoinServiceTest {

    JoinService service = new JoinService();
    EncryptUtils encryptUtils = new EncryptUtils();

//    @Test
//    void test01() {
//        UserDTOOriginal userDTOOriginal = new UserDTOOriginal("dcwang2@naver.com", "1234", "찬현", "01000000000", 1L, "1234");
//
//        boolean i = service.saveUser(userDTOOriginal);
//        System.out.println("i = " + i);
//    }
//
//    @Test
//    void insertOne() {
//        UserDTOOriginal userDTOOriginal = new UserDTOOriginal("test@naver.com", "1234", "테스트", "01012345678", 1L, null);
//        boolean b = service.saveUser(userDTOOriginal);
//    }
//
//    @Test
//    void insertMany() {
//        for (int i = 1; i < 22; i++) {
//            UserDTOOriginal userDTOOriginal = new UserDTOOriginal("test" + i + "@naver.com", "1234", "테스트" + i, "01012345678", 1L, null);
//            service.saveUser(userDTOOriginal);
//        }
//    }

    @Test
    void insertV2() {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("aaaa@naver.com");
        userDTO.setPassword("Cksgus892201*");
        userDTO.setName("테스트");
        userDTO.setPhone("01055933522");

        service.saveUser(userDTO);
    }

}