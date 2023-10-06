package com.xuanzhe.dao.user;

import com.xuanzhe.dao.BaseDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pojo.User;

public class UserDaoImpl implements UserDao {

  @Override
  public User getLoginUser(Connection connection, String userCode) {
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    User user = null;
    if (connection != null) {
      String sql = "select * from smbms_user where userCode = ?";
      Object[] params = {userCode};

      try {
        resultSet = BaseDao.execute(connection, sql, params, resultSet, preparedStatement);
        if(resultSet.next()){
          user = new User();
          user.setId(resultSet.getInt("id"));
          user.setUserCode(resultSet.getString("userCode"));
          user.setUserName(resultSet.getString("userName"));
          user.setUserPassword(resultSet.getString("userPassword"));
          user.setGender(resultSet.getInt("gender"));
          user.setBirthday(resultSet.getDate("birthday"));
          user.setPhone(resultSet.getString("phone"));
          user.setAddress(resultSet.getString("address"));
          user.setUserRole(resultSet.getInt("userRole"));
          user.setCreatedBy(resultSet.getInt("createdBy"));
          user.setCreationDate(resultSet.getTimestamp("creationDate"));
          user.setModifyBy(resultSet.getInt("modifyBy"));
          user.setModifyDate(resultSet.getTimestamp("modifyDate"));
        }
        BaseDao.closeResource(null,preparedStatement,resultSet);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
