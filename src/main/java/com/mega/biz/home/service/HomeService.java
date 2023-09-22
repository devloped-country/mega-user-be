package com.mega.biz.home.service;

import com.mega.biz.home.exception.NotDateContentException;
import com.mega.biz.home.model.HomeDAO;
import com.mega.biz.home.model.dto.HomeAttendanceDTO;
import com.mega.biz.home.model.dto.HomeCurriculumDTO;
import com.mega.biz.home.model.dto.HomeNoticeDTO;
import com.mega.biz.home.model.dto.HomeProfileDTO;
import java.sql.Timestamp;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class HomeService {

  HomeDAO dao = new HomeDAO();

  public ArrayList<HomeAttendanceDTO> getAttendanceStat(String name, String year, String month) throws NotDateContentException {
    ArrayList<HomeAttendanceDTO> homeAttendanceListDTO = dao.selectAttendnaceStat(name, year, month);

    if(homeAttendanceListDTO.size() == 0) {
      throw new NotDateContentException();
    }

    int date = YearMonth.of(Integer.parseInt(year), Integer.parseInt(month)).atEndOfMonth().getDayOfMonth();
    int startDay = homeAttendanceListDTO.get(0).getStartDate().getDate();
    int lastDay =  homeAttendanceListDTO.get(homeAttendanceListDTO.size()-1).getStartDate().getDate() + 1;

    if(startDay == 1) {
      for(int i=lastDay; i<=date; i++) {
        HomeAttendanceDTO homeAttendanceDTO = new HomeAttendanceDTO();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(year), Integer.parseInt(month) - 1, i); // 월은 0부터 시작하므로 1을 빼줍니다

        Date calDate = calendar.getTime();
        int day = calendar.getTime().getDay();

        if(day == 0 || day == 6) {
          continue;
        }

        Timestamp timestamp = new Timestamp(calDate.getTime());
        homeAttendanceDTO.setStartDate(timestamp);
        homeAttendanceDTO.setStat(1);

        homeAttendanceListDTO.add(homeAttendanceDTO);
      }
    }
    else if(startDay != 1) {
      for(int i=startDay-1; i>0; i--) {
        HomeAttendanceDTO homeAttendanceDTO = new HomeAttendanceDTO();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(year), Integer.parseInt(month) - 1, i); // 월은 0부터 시작하므로 1을 빼줍니다

        Date calDate = calendar.getTime();
        int day = calendar.getTime().getDay();

        if(day == 0 || day == 6) {
          continue;
        }

        Timestamp timestamp = new Timestamp(calDate.getTime());
        homeAttendanceDTO.setStartDate(timestamp);
        homeAttendanceDTO.setStat(1);

        homeAttendanceListDTO.add(0, homeAttendanceDTO);
      }
    }

    return homeAttendanceListDTO;
  }

  public ArrayList<HomeCurriculumDTO> getRecentCurriculum() {
    return dao.selectRecentCurriculum();
  }

  public ArrayList<HomeNoticeDTO> getRecentNotice() {
    ArrayList<HomeNoticeDTO> homeNoticeListDTO = dao.selectRecentNotice();
    for (HomeNoticeDTO homeNoticeDTO: homeNoticeListDTO) {
      switch (homeNoticeDTO.getTagId()) {
        case 1:
          homeNoticeDTO.setTag("훈련비");
          break;
        case 2:
          homeNoticeDTO.setTag("시험");
          break;
        case 3:
          homeNoticeDTO.setTag("BIPA행사관련");
          break;
        case 4:
          homeNoticeDTO.setTag("BIPA전달사항");
          break;
        case 5:
          homeNoticeDTO.setTag("BIPA채용공지");
          break;
        case 6:
          homeNoticeDTO.setTag("세미나");
          break;
        case 7:
          homeNoticeDTO.setTag("긴급");
          break;
        default:
          homeNoticeDTO.setTag("기타");
          break;
      }
    }

    return homeNoticeListDTO;
  }

  public ArrayList<HomeProfileDTO> getHomeProfile(String name) {
    int duration = dao.selectDuration();
    return dao.selectProfileAttendance(name, duration);
  }
}
