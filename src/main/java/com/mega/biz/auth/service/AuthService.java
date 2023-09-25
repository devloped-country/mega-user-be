package com.mega.biz.auth.service;

import com.mega.biz.auth.model.AuthDAO;
import com.mega.biz.auth.model.dto.NameDTO;
import com.mega.biz.login.exception.TokenException;
import com.mega.biz.auth.model.dto.AuthDTO;
import com.mega.common.jwt.Jwt;

public class AuthService {

  AuthDAO dao = new AuthDAO();

  public void validateAccessToken(String token) throws TokenException {
    Jwt.validateIssuer(token);
  }

  public void getNewAccess(AuthDTO authDTO, String email, String name, int time) {
    String access = Jwt.create(email, name, time);
    authDTO.setAccess(access);
  }

  public void getNewRefresh(AuthDTO authDTO, String email, String name, int time) {
    String newRefreshToken = Jwt.create(email, name, time);
    authDTO.setRefresh(newRefreshToken);
    updateRefresh(newRefreshToken, email);
  }

  public void updateRefresh(String newRefreshToken, String email) {
    dao.updateRefresh(newRefreshToken, email);
  }

  public NameDTO getName(String refreshToken) {
    NameDTO nameDTO = new NameDTO();

    nameDTO.setName(dao.selectName(refreshToken));

    return nameDTO;
  }
}
