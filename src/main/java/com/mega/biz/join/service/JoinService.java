package com.mega.biz.join.service;

import com.mega.biz.join.model.JoinDAO;
import com.mega.biz.join.model.dto.UserDTO;
import com.mega.biz.join.model.dto.UserValidationDTO;
import com.mega.common.encrypt.EncryptUtils;

public class JoinService {

    private final JoinDAO dao = new JoinDAO();

    private final EncryptUtils encrypt = new EncryptUtils();

    public boolean saveUser(UserValidationDTO userValidationDTO) {
        String salt = encrypt.getSalt();
        userValidationDTO.setSalt(salt);

        String encryptedPassword = encrypt.getEncrypt(userValidationDTO.getPassword(), salt);
        userValidationDTO.setEncrypedPassword(encryptedPassword);
        userValidationDTO.setUserStatus(1L);

        int i = dao.insertUser(userValidationDTO);
        dao.insertAttendance(userValidationDTO);
        return i == 1;
    }

    public UserDTO findUser(UserDTO userDTO) {
        return dao.findUser(userDTO);
    }
}
