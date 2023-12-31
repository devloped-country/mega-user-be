package com.mega.biz.notice.controller;

import com.google.gson.Gson;
import com.mega.biz.notice.model.dto.NoticeDTO;
import com.mega.biz.notice.service.NoticeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/notice/*")
public class NoticeDetailController extends HttpServlet {

    private final NoticeService service = new NoticeService();
    Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] queries = request.getRequestURI().split("/");
        String id = queries[2];

        NoticeDTO noticeDTO = service.getDetailList(id);

        String json = gson.toJson(noticeDTO);

        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(json);
    }
}
