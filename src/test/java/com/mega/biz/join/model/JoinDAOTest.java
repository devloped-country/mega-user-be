package com.mega.biz.join.model;

import com.mega.biz.join.model.dto.UserDTOOriginal;
import org.junit.jupiter.api.Test;

class JoinDAOTest {

    JoinDAO dao = new JoinDAO();

//    @Test
//    void test01() {
//        UserDTOOriginal userDTOOriginal = new UserDTOOriginal("dcwang@naver.com", "1234", "찬현", "01000000000", 1L, "1234");
//
//        int i = dao.insertUser(userDTOOriginal);
//
//        System.out.println("i = " + i);
//    }

    @Test
    void test02() {
        UserDTOOriginal userDTOOriginal = new UserDTOOriginal();
        userDTOOriginal.setEmail("dcwang100@naver.com");
        UserDTOOriginal user = dao.findUser(userDTOOriginal);

        System.out.println("user = " + user);
    }

}