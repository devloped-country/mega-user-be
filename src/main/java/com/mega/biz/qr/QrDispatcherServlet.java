package com.mega.biz.qr;

import com.google.gson.Gson;
import com.mega.biz.qr.exception.QrException;
import com.mega.biz.qr.exception.ReAuthException;
import com.mega.biz.qr.model.dto.QrDTO;
import com.mega.common.controller.Controller;
import com.mega.common.controller.ControllerUtils;
import com.mega.common.controller.HandlerMapping;
import com.mega.common.controller.ViewResolver;

import com.mega.common.error.ErrorCode;
import com.mega.common.error.ErrorStatus;
import java.net.URLDecoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/qr/*")
public class QrDispatcherServlet extends HttpServlet {

  private HandlerMapping handlerMapping;
  private ViewResolver viewResolver;

  private static final int QR_QUERY_STRING_INDEX = 1;

  public void init() throws ServletException {
    handlerMapping = new QrHandlerMapping();
    viewResolver = new ViewResolver();
    viewResolver.setPrefix("/WEB-INF/view/qr/");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String uri = request.getRequestURI();
    String[] qrString = request.getQueryString().split("=");
    String[] qrs = qrString[QR_QUERY_STRING_INDEX].split("&");
    String qr = qrs[0];
    String path = uri.substring(uri.lastIndexOf("/"));
    Controller ctrl = handlerMapping.getController(path);
    Gson gson = new Gson();

    if (ctrl == null) {
      response.setStatus(404);
      response.getWriter().write("");
    }
    System.out.println(qr + "qr임다");
    request.setAttribute("email", URLDecoder.decode(qrString[2]));
    request.setAttribute("qr", qr);

    try {
      QrDTO qrDTO = (QrDTO) ctrl.handleRequest(request, response);
      String json = gson.toJson(qrDTO);

      response.setStatus(200);
      response.getWriter().write(json);
    } catch (QrException e) {
      e.printStackTrace();
      response.setStatus(401);

      ErrorStatus errorStatus = new ErrorStatus(ErrorCode.ERROR_CODE_FIRST.getErrorCode());
      String json = gson.toJson(errorStatus);

      response.getWriter().write(json);
    } catch (ReAuthException e) {
      e.printStackTrace();
      response.setStatus(401);

      ErrorStatus errorStatus = new ErrorStatus(ErrorCode.ERROR_CODE_SECOND.getErrorCode());
      String json = gson.toJson(errorStatus);

      response.getWriter().write(json);
    }
  }
}
