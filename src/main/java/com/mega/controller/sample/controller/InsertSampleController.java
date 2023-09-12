package com.mega.controller.sample.controller;

import com.mega.controller.Controller;
import com.mega.model.sample.dto.SampleDTO;
import com.mega.service.sample.SampleService;

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
