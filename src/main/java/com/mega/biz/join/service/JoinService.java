package com.mega.biz.join.service;

import com.mega.biz.join.model.JoinDAO;
import com.mega.biz.join.model.dto.UserDTO;
import com.mega.common.encrypt.EncryptUtils;

public class JoinService {

    private final JoinDAO dao = new JoinDAO();

    private final EncryptUtils encrypt = new EncryptUtils();


    public boolean insertUser(UserDTO userDTO) {
        String salt = encrypt.getSalt();
        userDTO.setSalt(salt);

        String encryptedPassword = encrypt.getEncrypt(userDTO.getPassword(), salt);
        userDTO.setPassword(encryptedPassword);
        userDTO.setUserStatus(1L);  // TODO: 2023-09-19 status 확인 필요

        int i = dao.insertUser(userDTO);
        return i == 1;
    }

    public UserDTO findUser(UserDTO userDTO) {
        return dao.findUser(userDTO);
    }
}
