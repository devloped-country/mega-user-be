package com.mega.biz.login.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mega.biz.login.exception.AuthException;
import com.mega.biz.login.model.dto.AuthDTO;
import com.mega.biz.login.model.dto.LoginDTO;
import com.mega.biz.login.model.dto.TokenDTO;
import com.mega.biz.login.service.LoginService;
import com.mega.common.controller.ControllerUtils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet {
  private final LoginService service = new LoginService();

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String body = ControllerUtils.getBody(request);

    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    LoginDTO loginDTO = gson.fromJson(body, LoginDTO.class);

    try {
      AuthDTO authDTO = service.authUser(loginDTO);
      String result = gson.toJson(authDTO);

      response.setStatus(200);
      response.getWriter().write(result);
    } catch (AuthException e) {
      response.setStatus(401);
      response.getWriter().write("");
    }
  }
}
