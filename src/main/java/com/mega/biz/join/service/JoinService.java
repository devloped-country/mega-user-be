package com.mega.biz.join.service;

import com.mega.biz.join.model.JoinDAO;
import com.mega.biz.join.model.dto.UserDTO;
import com.mega.biz.join.model.dto.UserDTOv;
import com.mega.common.encrypt.EncryptUtils;

public class JoinService {

    private final JoinDAO dao = new JoinDAO();

    private final EncryptUtils encrypt = new EncryptUtils();


    public boolean saveUser(UserDTO userDTO) {
        String salt = encrypt.getSalt();
        userDTO.setSalt(salt);

        String encryptedPassword = encrypt.getEncrypt(userDTO.getPassword(), salt);
        userDTO.setPassword(encryptedPassword);
        userDTO.setUserStatus(1L);

        int i = dao.insertUser(userDTO);
        return i == 1;
    }

    public boolean saveUser2(UserDTOv userDTO) {
        String salt = encrypt.getSalt();
        userDTO.setSalt(salt);

        String encryptedPassword = encrypt.getEncrypt(userDTO.getPassword(), salt);
        userDTO.setEncrypedPassword(encryptedPassword);
        userDTO.setUserStatus(1L);

        int i = dao.insertUser2(userDTO);
        return i == 1;
    }

    public UserDTO findUser(UserDTO userDTO) {
        return dao.findUser(userDTO);
    }
}
