package com.mega.biz.join.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mega.biz.join.model.dto.UserValidationDTO;
import com.mega.biz.join.model.UserDTODeserializer;
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

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(UserValidationDTO.class, new UserDTODeserializer());
        Gson gson = gsonBuilder.create();
        boolean flag = false;

        try {
            UserValidationDTO userValidationDTO = gson.fromJson(body, UserValidationDTO.class);
            flag = service.saveUser(userValidationDTO);
        } catch (IllegalArgumentException e) {
            String message = e.getMessage();
            log.info("[error message] : {}", message);
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write(message + "\n");
        }

        if (flag) {
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("OK");
            log.info("{}", "success");
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("NO");
            log.info("{}", "fail");
        }
    }
}