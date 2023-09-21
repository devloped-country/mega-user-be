package com.mega.biz.home.controller;

import com.google.gson.Gson;
import com.mega.biz.home.model.dto.HomeProfileDTO;
import com.mega.biz.home.service.HomeService;
import com.mega.biz.login.model.dto.AuthDTO;
import com.mega.biz.login.model.dto.TokenDTO;
import com.mega.common.jwt.Jwt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home/profile")
public class HomeProfileController extends HttpServlet {
  private final HomeService service = new HomeService();
  Gson gson = new Gson();

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String[] queries = request.getQueryString().split("=");
    String name = queries[1];

    AuthDTO authDTO = (AuthDTO) request.getAttribute("code");
    System.out.println(authDTO.getStatusCode());

    if (authDTO.getStatusCode() == -1) {
      TokenDTO tokenDTO = new TokenDTO();
      Jwt.create(600000)

      response.setStatus(401);
      response.getWriter().write("");
      return;
    }

    ArrayList<HomeProfileDTO> homeProfileDTO = service.getHomeProfile(name);

    String result = gson.toJson(homeProfileDTO);

    response.setStatus(200);
    response.getWriter().write(result);
  }
}