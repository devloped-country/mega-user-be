package com.mega.biz.login.service;

import com.mega.biz.login.model.LoginDAO;
import com.mega.biz.login.model.dto.LoginDTO;
import com.mega.common.encrypt.EncryptUtils;

public class LoginService {
  private final LoginDAO dao = new LoginDAO();
  private EncryptUtils encrypt = new EncryptUtils();

  public boolean authUser(LoginDTO loginDTO) {
    LoginDTO dto = dao.selectAuth(loginDTO);

    String inputPassword = encrypt.getEncrypt(loginDTO.getPassword(), dto.getSalt());
    String password = encrypt.getEncrypt(dto.getPassword(), dto.getSalt());

    if(inputPassword.equals(password)) {
      return true;
    }

    return false;
  }
}
