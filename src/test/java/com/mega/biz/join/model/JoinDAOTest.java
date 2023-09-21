package com.mega.biz.join.model;

import com.mega.biz.join.model.dto.UserDTO;
import org.junit.jupiter.api.Test;

class JoinDAOTest {

    JoinDAO dao = new JoinDAO();

    @Test
    void test02() {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("dcwang100@naver.com");
        UserDTO user = dao.findUser(userDTO);

        System.out.println("user = " + user);
    }

}