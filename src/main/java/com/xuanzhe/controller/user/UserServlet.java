package com.xuanzhe.controller.user;

import com.mysql.cj.util.StringUtils;
import com.xuanzhe.service.user.UserService;
import com.xuanzhe.service.user.UserServiceImpl;
import com.xuanzhe.util.Constants;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String method = req.getParameter("method");
    if(method.equals("savepwd")&&method!=null){
      this.updatePwd(req,resp);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    doGet(req, resp);
  }

  public void updatePwd(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Object attribute = req.getSession().getAttribute(Constants.USER_SESSION);
    String newpassword = req.getParameter("newpassword");
    boolean flag = false;
    if (attribute != null && !StringUtils.isNullOrEmpty(newpassword)) {
      UserService userService = new UserServiceImpl();
      try {
        flag = userService.updatePwd(((pojo.User) attribute).getId(), newpassword);
      } catch (SQLException e) {
        e.printStackTrace();
      }
      if (flag == true) {
        req.setAttribute("message", "Change password successfully, use new password to login");
        req.getSession().removeAttribute(Constants.USER_SESSION);
      } else {
        req.setAttribute("massage", "Failed to change password");
      }
    } else {
      req.setAttribute("message", "Inconsistency between oldand new codes");
    }
    req.getRequestDispatcher("pwdmodify.jsp").forward(req, resp);
  }
}


