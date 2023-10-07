package com.xuanzhe.dao.user;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDao {
  //We need to get the user who needs to log in
  public pojo.User getLoginUser(Connection connection, String userCode);
  public int updatePwd(Connection connection, int id, String password) throws SQLException;

}
