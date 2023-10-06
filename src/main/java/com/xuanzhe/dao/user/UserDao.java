package com.xuanzhe.dao.user;

import java.sql.Connection;

public interface UserDao {
  //We need to get the user who needs to log in
  public pojo.User getLoginUser(Connection connection, String userCode);

}
