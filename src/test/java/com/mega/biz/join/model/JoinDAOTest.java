package com.mega.biz.join.model;

import com.mega.biz.join.model.dto.UserDTO;
import com.mega.biz.join.model.dto.UserValidationDTO;
import org.junit.jupiter.api.Test;

class JoinDAOTest {

    JoinDAO dao = new JoinDAO();

    @Test
    void test02() {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("dcwang100@naver.com");
        UserDTO user = dao.findUser(userDTO);
    }

    @Test
    void insertAttendance() {
        UserValidationDTO dto = new UserValidationDTO();
        dto.setEmail("dcwang1@naver.com");
        dao.insertAttendance(dto);
    }

    @Test
    void shaTest() {
        UserValidationDTO dto = new UserValidationDTO();
        dto.setEmail("ccc@ccc.com");
        dto.setPassword("Test1234!");
        dto.setName("bbbb");
        dto.setPhone("01055933522");
        dto.setUserStatus(1L);

        dao.insertUser(dto);
    }

}