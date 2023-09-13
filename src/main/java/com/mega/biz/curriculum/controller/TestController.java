package com.mega.biz.curriculum.controller;

import com.mega.common.controller.Controller;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class TestController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        log.info("method = {}", request.getMethod());
        return "test";
    }
}
