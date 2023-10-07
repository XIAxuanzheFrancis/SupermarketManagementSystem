package com.xuanzhe.controller.user;

import com.xuanzhe.service.user.UserService;
import com.xuanzhe.service.user.UserServiceImpl;
import com.xuanzhe.util.Constants;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String userCode = req.getParameter("userCode");
    String userPassword = req.getParameter("userPassword");

    UserService userService = new UserServiceImpl();
    pojo.User user = userService.login(userCode, userPassword);
    if(user!=null){
      //ce user existe
      req.getSession().setAttribute(Constants.USER_SESSION,user);
      resp.sendRedirect("jsp/frame.jsp");
    }
    else{
      req.setAttribute("error","The username or password is incorrect");
      req.getRequestDispatcher("login.jsp").forward(req,resp);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    doGet(req, resp);
  }
}
