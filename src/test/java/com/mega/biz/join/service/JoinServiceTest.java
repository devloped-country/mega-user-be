package com.mega.biz.join.service;

import com.mega.biz.join.model.dto.UserValidationDTO;
import com.mega.common.encrypt.EncryptUtils;
import org.junit.jupiter.api.Test;

class JoinServiceTest {

    JoinService service = new JoinService();
    EncryptUtils encryptUtils = new EncryptUtils();

    @Test
    void insertV2() {
        UserValidationDTO userValidationDTO = new UserValidationDTO();
        userValidationDTO.setEmail("ccc@ccc.com");
        userValidationDTO.setPassword("Test1234!");
        userValidationDTO.setName("테스트");
        userValidationDTO.setPhone("01055933522");

        service.saveUser(userValidationDTO);
    }

}