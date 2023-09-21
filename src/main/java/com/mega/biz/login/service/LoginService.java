package com.mega.biz.login.service;

import com.mega.biz.login.exception.AuthException;
import com.mega.biz.login.model.LoginDAO;
import com.mega.biz.login.model.dto.LoginDTO;
import com.mega.biz.login.model.dto.TokenDTO;
import com.mega.common.encrypt.EncryptUtils;
import com.mega.common.jwt.Jwt;

public class LoginService {

  private final LoginDAO dao = new LoginDAO();
  private final EncryptUtils encrypt = new EncryptUtils();

  public TokenDTO authUser(LoginDTO loginDTO) throws AuthException {
    LoginDTO dto = dao.selectAuth(loginDTO);
    String inputPassword = encrypt.getEncrypt(loginDTO.getPassword(), dto.getSalt());
    String password = dto.getPassword();

    if (!inputPassword.equals(password)) {
      throw new AuthException("인증 에러");
    }

    TokenDTO tokenDTO = new TokenDTO();

    String accessToken = Jwt.create(dto.getEmail(), dto.getName(), 1);
    tokenDTO.setAccessToken(accessToken);

    String refreshToken = Jwt.create(dto.getEmail(), dto.getName(), 3600000 * 24 * 14);
    tokenDTO.setRefreshToken(refreshToken);

    dao.updateRefresh(dto, tokenDTO);

    return tokenDTO;
  }
}
