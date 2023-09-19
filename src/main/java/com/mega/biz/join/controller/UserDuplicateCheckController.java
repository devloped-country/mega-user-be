package com.mega.biz.join.controller;

import com.google.gson.Gson;
import com.mega.biz.join.model.dto.UserDTO;
import com.mega.biz.join.service.JoinService;
import com.mega.common.controller.ControllerUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userCheck")
public class UserDuplicateCheckController extends HttpServlet {

    private final JoinService service = new JoinService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String body = ControllerUtils.getBody(request);

        Gson gson = new Gson();
        UserDTO userDTO = gson.fromJson(body, UserDTO.class);

        UserDTO user = service.findUser(userDTO);

        if (user != null) {
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("OK");
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("NO");
        }
    }
}
