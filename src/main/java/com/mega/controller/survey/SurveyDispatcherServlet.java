package com.mega.controller.survey;

import com.mega.controller.Controller;
import com.mega.controller.HandlerMapping;
import com.mega.controller.ViewResolver;
import com.mega.controller.curriculum.CurriculumHandlerMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/survey/*")
public class SurveyDispatcherServlet extends HttpServlet {

    private HandlerMapping handlerMapping;
    private ViewResolver viewResolver;

    public void init() throws ServletException {
        handlerMapping = new SurveyHandlerMapping();
        viewResolver = new ViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/survey/");
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
