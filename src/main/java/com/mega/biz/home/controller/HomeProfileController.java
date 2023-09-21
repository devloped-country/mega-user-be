package com.mega.biz.home.controller;

import com.google.gson.Gson;
import com.mega.biz.home.model.dto.HomeProfileDTO;
import com.mega.biz.home.service.HomeService;
import java.io.IOException;
import java.util.ArrayList;
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
    System.out.println(request.getAttribute("token"));

    ArrayList<HomeProfileDTO> homeProfileDTO = service.getHomeProfile(name);

    String result = gson.toJson(homeProfileDTO);

    response.setStatus(200);
    response.getWriter().write(result);
  }
}