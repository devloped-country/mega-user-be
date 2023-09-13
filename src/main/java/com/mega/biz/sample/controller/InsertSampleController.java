package com.mega.biz.sample.controller;

import com.mega.common.controller.Controller;
import com.mega.biz.sample.model.dto.SampleDTO;
import com.mega.biz.sample.service.SampleService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertSampleController implements Controller {

    private final SampleService service = new SampleService();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String role = request.getParameter("role");

        SampleDTO sampleDTO = new SampleDTO(id, password, name, role);

        service.insertUser(sampleDTO);

        return "getUserList.do";
    }
}
