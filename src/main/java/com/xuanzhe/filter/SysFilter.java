package com.xuanzhe.filter;

import com.xuanzhe.util.Constants;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.User;

public class SysFilter implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest)servletRequest;
    HttpServletResponse resp = (HttpServletResponse) servletResponse;

    pojo.User user = (User) req.getSession().getAttribute(Constants.USER_SESSION);
    if(user == null){
      resp.sendRedirect(req.getContextPath()+"/error.jsp");
    }
    else{
      filterChain.doFilter(req,resp);
    }
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void destroy() {
  }
}
