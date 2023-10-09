package com.xuanzhe.service.user;

import com.xuanzhe.dao.BaseDao;
import com.xuanzhe.dao.user.UserDao;
import com.xuanzhe.dao.user.UserDaoImpl;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;
import pojo.User;

public class UserServiceImpl implements UserService{
  private UserDao userDao;
  public UserServiceImpl(){
    userDao = new UserDaoImpl();
  }
  @Override
  public User login(String userCode, String password) {
    Connection connection = null;
    User user = null;

    connection = BaseDao.getConnection();
    user = userDao.getLoginUser(connection, userCode);
    BaseDao.closeResource(connection, null, null);
    return user;
  }
  /*
  @Test
  public void test(){
    UserServiceImpl userService = new UserServiceImpl();
    User admin = userService.login("admin","1vfd23456");
    System.out.println(admin.getUserPassword());
  }

   */

  @Override
  public boolean updatePwd(int id, String password) throws SQLException {
    Connection connection = null;
    boolean flag = false;
    connection = BaseDao.getConnection();
    if(userDao.updatePwd(connection,id,password)>0){
      flag = true;
    }
    BaseDao.closeResource(connection,null,null);
    return flag;
  }
}
