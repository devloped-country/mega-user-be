package com.mega.biz.home.service;

import com.mega.biz.home.model.HomeDAO;
import com.mega.biz.home.model.dto.HomeAttendanceDTO;
import java.util.ArrayList;

public class HomeService {

  HomeDAO dao = new HomeDAO();

  public ArrayList<HomeAttendanceDTO> getAttendanceStat(String name) {
    ArrayList<HomeAttendanceDTO> homeAttendanceListDTO = dao.selectAttendnaceStat(name);
    return homeAttendanceListDTO;
  }
}
