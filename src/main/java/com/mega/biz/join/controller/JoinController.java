package com.mega.biz.join.controller;

import com.google.gson.Gson;
import com.mega.biz.join.model.dto.UserDTO;
import com.mega.biz.join.service.JoinService;
import com.mega.common.controller.ControllerUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet("/join")
public class JoinController extends HttpServlet {

    private final JoinService service = new JoinService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String body = ControllerUtils.getBody(request);

        Gson gson = new Gson();
        UserDTO userDTO = gson.fromJson(body, UserDTO.class);
        boolean flag = service.saveUser(userDTO);

        if (flag) {
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("OK");
            log.info("{}", "success");
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("NO");
            log.info("{}", "fail");
        }
    }
}