package com.mega.biz.home.controller;

import com.google.gson.Gson;
import com.mega.biz.home.model.dto.HomeCurriculumDTO;
import com.mega.biz.home.model.dto.HomeNoticeDTO;
import com.mega.biz.home.service.HomeService;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home/notice")
public class HomeNoticeController extends HttpServlet {
  private final HomeService service = new HomeService();
  Gson gson = new Gson();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ArrayList<HomeNoticeDTO> homeNoticeListDTO = service.getRecentNotice();

    String result = gson.toJson(homeNoticeListDTO);

    response.setStatus(200);
    response.getWriter().write(result);
  }
}
