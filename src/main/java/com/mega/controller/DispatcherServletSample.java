package com.mega.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatcherServletSample extends HttpServlet {

    private HandlerMapping handlerMapping;
    private ViewResolver viewResolver;

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"));

        Controller ctrl = handlerMapping.getController(path);

        String viewName = ctrl.handleRequest(request, response);
        String view = null;

        if (!viewName.contains(".do")) {
            if (viewName.equals("index")) {
                view = viewName + ".jsp";
            } else {
                view = viewResolver.getView(viewName);
            }
        } else {
            view = viewName;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
}
