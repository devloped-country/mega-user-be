package com.mega.biz.home.controller;

import com.google.gson.Gson;
import com.mega.biz.home.model.dto.HomeAttendanceDTO;
import com.mega.biz.home.service.HomeService;
import com.mega.common.controller.Controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeController extends HttpServlet {

  private final HomeService service = new HomeService();
  Gson gson = new Gson();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String[] parts = request.getQueryString().split("&");
    String name = null;
    String year = null;
    String month = null;

    for(String part : parts) {
      String[] queries = part.split("=");
      if(queries[0].equals("name")) {
        name = queries[1];
      } else if(queries[0].equals("year")) {
        year = queries[1];
      } else if(queries[0].equals("month")) {
        month = queries[1];
      }
    }

    ArrayList<HomeAttendanceDTO> homeAttendanceListDTO = service.getAttendanceStat(name, year, month);
    String result = gson.toJson(homeAttendanceListDTO);

    response.setStatus(200);
    response.getWriter().write(result);
  }
}
