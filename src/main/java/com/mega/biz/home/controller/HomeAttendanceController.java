package com.mega.biz.home.controller;

import com.google.gson.Gson;
import com.mega.biz.home.exception.NotDateContentException;
import com.mega.biz.home.model.dto.HomeAttendanceDTO;
import com.mega.biz.home.service.HomeService;

import com.mega.common.error.ErrorCode;
import com.mega.common.error.ErrorStatus;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home/attendance")
public class HomeAttendanceController extends HttpServlet {

  private final HomeService service = new HomeService();
  Gson gson = new Gson();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String[] parts = request.getQueryString().split("&");
    String token = null;
    String year = null;
    String month = null;

    for(String part : parts) {
      String[] queries = part.split("=");
      if(queries[0].equals("token")) {
        token = queries[1];
      } else if(queries[0].equals("year")) {
        year = queries[1];
      } else if(queries[0].equals("month")) {
        month = queries[1];
      }
    }

    String result = null;
    try {
    ArrayList<HomeAttendanceDTO> homeAttendanceListDTO = service.getAttendanceStat(token, year, month);
      result = gson.toJson(homeAttendanceListDTO);
    } catch(NotDateContentException e) {
      ErrorStatus errorStatus = new ErrorStatus(ErrorCode.ERROR_CODE_FIRST.getErrorCode());

      String error = gson.toJson(errorStatus);
      response.setStatus(200);
      response.getWriter().write(error);
      return;
    }

    response.setStatus(200);
    response.getWriter().write(result);
  }
}
