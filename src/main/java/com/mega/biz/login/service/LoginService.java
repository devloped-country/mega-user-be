package com.mega.biz.login.service;

import com.mega.biz.login.exception.AuthException;
import com.mega.biz.login.model.LoginDAO;
import com.mega.biz.login.model.dto.AuthDTO;
import com.mega.biz.login.model.dto.LoginDTO;
import com.mega.biz.login.model.dto.TokenDTO;
import com.mega.common.encrypt.EncryptUtils;
import com.mega.common.jwt.Jwt;

public class LoginService {

  private final LoginDAO dao = new LoginDAO();
  private final EncryptUtils encrypt = new EncryptUtils();

  public AuthDTO authUser(LoginDTO loginDTO) throws AuthException {
    LoginDTO dto = dao.selectAuth(loginDTO);
    String inputPassword = encrypt.getEncrypt(loginDTO.getPassword(), dto.getSalt());
    String password = dto.getPassword();

    if (!inputPassword.equals(password)) {
      throw new AuthException();
    }

    AuthDTO authDTO = new AuthDTO();

    String accessToken = Jwt.create(dto.getEmail(), dto.getName(), 6000000);
    authDTO.setAccessToken(accessToken);

    String refreshToken = Jwt.create(dto.getEmail(), dto.getName(), 3600000 * 24 * 14);
    authDTO.setRefreshToken(refreshToken);

    dao.updateRefresh(dto, authDTO);

    return authDTO;
  }
}
