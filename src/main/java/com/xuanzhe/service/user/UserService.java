package com.xuanzhe.service.user;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserService {
  public pojo.User login(String userCode, String password);

  public boolean updatePwd(int id,String password) throws SQLException;
}
