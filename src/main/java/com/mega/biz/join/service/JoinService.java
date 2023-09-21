package com.mega.biz.join.service;

import com.mega.biz.join.model.JoinDAO;
import com.mega.biz.join.model.dto.UserDTOOriginal;
import com.mega.biz.join.model.dto.UserDTO;
import com.mega.common.encrypt.EncryptUtils;

public class JoinService {

    private final JoinDAO dao = new JoinDAO();

    private final EncryptUtils encrypt = new EncryptUtils();


//    public boolean saveUser(UserDTOOriginal userDTOOriginal) {
//        String salt = encrypt.getSalt();
//        userDTOOriginal.setSalt(salt);
//
//        String encryptedPassword = encrypt.getEncrypt(userDTOOriginal.getPassword(), salt);
//        userDTOOriginal.setPassword(encryptedPassword);
//        userDTOOriginal.setUserStatus(1L);
//
//        int i = dao.insertUser(userDTOOriginal);
//        return i == 1;
//    }

    public boolean saveUser(UserDTO userDTO) {
        String salt = encrypt.getSalt();
        userDTO.setSalt(salt);

        String encryptedPassword = encrypt.getEncrypt(userDTO.getPassword(), salt);
        userDTO.setEncrypedPassword(encryptedPassword);
        userDTO.setUserStatus(1L);

        int i = dao.insertUser(userDTO);
        return i == 1;
    }

    public UserDTOOriginal findUser(UserDTOOriginal userDTOOriginal) {
        return dao.findUser(userDTOOriginal);
    }
}
