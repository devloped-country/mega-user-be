package com.mega.biz.join.model;

import com.mega.biz.join.model.dto.UserDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JoinDAOTest {

    JoinDAO dao = new JoinDAO();

    @Test
    void test01() {
        UserDTO userDTO = new UserDTO("dcwang@naver.com", "1234", "찬현", "01000000000", 1L, "1234");

        int i = dao.insertUser(userDTO);

        System.out.println("i = " + i);
    }

    @Test
    void test02() {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("dcwang100@naver.com");
        UserDTO user = dao.findUser(userDTO);

        System.out.println("user = " + user);
    }

}