package com.mega.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
    Object handleRequest(HttpServletRequest request, HttpServletResponse response);
}
