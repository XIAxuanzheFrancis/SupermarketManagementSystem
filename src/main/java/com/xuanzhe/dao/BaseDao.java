package com.xuanzhe.dao;

import com.mysql.jdbc.Driver;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDao {

  private static String driver;
  private static String url;
  private static String username;
  private static String password;

  static {
    Properties properties = new Properties();
    InputStream resourceAsStream = BaseDao.class.getClassLoader()
        .getResourceAsStream("db.properties");
    try {
      properties.load(resourceAsStream);
    } catch (IOException e) {
      e.printStackTrace();
    }
    driver = properties.getProperty("driver");
    url = properties.getProperty("url");
    username = properties.getProperty("username");
    password = properties.getProperty("password");
  }

  //Obtenir une connexion à la base de données
  public static Connection getConnection() {
    Connection connection = null;
    try {
      Class.forName(driver);
      connection = DriverManager.getConnection(url, username, password);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return connection;
  }

  //Méthode d'enquête publique
  public static ResultSet execute(Connection connection, String sql, Object[] params,ResultSet resultSet, PreparedStatement preparedStatement)
      throws SQLException {
    preparedStatement = connection.prepareStatement(sql);
    for (int i = 0; i < params.length; i++) {
      preparedStatement.setObject(i+1,params[i]);
    }
    resultSet = preparedStatement.executeQuery();
    return resultSet;
  }

  //Méthodes publiques d'ajout, de suppression et de modification
  public static int execute(Connection connection, String sql, Object[] params, PreparedStatement preparedStatement)
      throws SQLException {
    preparedStatement = connection.prepareStatement(sql);
    for (int i = 0; i < params.length; i++) {
      preparedStatement.setObject(i+1,params[i]);
    }
    int updateRows = preparedStatement.executeUpdate();
    return updateRows;
  }

  public static boolean closeResource(Connection connection, PreparedStatement preparedStatement,ResultSet resultSet){
    boolean flag = true;
    if(resultSet!=null){
      try {
        resultSet.close();
        resultSet = null;
      } catch (SQLException e) {
        e.printStackTrace();
        flag = false;
      }
    }

    if(preparedStatement!=null){
      try {
        preparedStatement.close();
        preparedStatement = null;
      } catch (SQLException e) {
        e.printStackTrace();
        flag = false;
      }
    }


    if(connection!=null){
      try {
        connection.close();
        connection = null;
      } catch (SQLException e) {
        e.printStackTrace();
        flag = false;
      }
    }

    return flag;
  }
}