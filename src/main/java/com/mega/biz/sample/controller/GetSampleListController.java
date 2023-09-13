package com.mega.biz.sample.controller;

import com.mega.common.controller.Controller;
import com.mega.biz.sample.model.dto.SampleDTO;
import com.mega.biz.sample.service.SampleService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
public class GetSampleListController implements Controller {

    private final SampleService service = new SampleService();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        String test = "test01";

        log.info("log test = {}", test);
        log.info("class = {}", getClass());

        List<SampleDTO> userList = service.getUserList();
        request.setAttribute("userList", userList);
        return "userList";
    }
}
