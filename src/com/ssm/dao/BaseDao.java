package com.ssm.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
/**
 * 基础类
 * 	用于连接数据库和实现各种操作的基类
 * @author Arthas
 *
 */
public class BaseDao {

	/**
	 * 连接数据库所需要的属性
	 */
	private static String className;
	private static String url;
	private static String user;
	private static String password;
	
	/**
	 * 连接数据库所需要的工具
	 */
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	/**
	 * 获取数据库的连接
	 * 方式二:通过properties文件获得数据库连接
	 */
	public Connection getConnection() {
		try {
			Class.forName(className);
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	/**
	 * 获取properties文件属性
	 * 并用静态代码块来初始加载属性
	 */
	public static void init() {
		Properties properties = new Properties();
		String file = "database.properties";
		InputStream inputStream = BaseDao.class.getClassLoader().getResourceAsStream(file);
		try {
			properties.load(inputStream);
			className = properties.getProperty("driverClassName");
			url = properties.getProperty("url");
			user = properties.getProperty("username");
			password = properties.getProperty("password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 静态加载,Writer Once,Run Anywhere
	static {
		init();
	}
	
	
	/**
	 * 增删改通用方法
	 */
	 public int executeUpdate(String sql, Object... objects) {
		int result = -1;
		try {
			connection = this.getConnection();
			preparedStatement = connection.prepareStatement(sql.toString());
			for (int i = 0; i < objects.length; i++) {
				preparedStatement.setObject(i + 1, objects[i]);
			}
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(resultSet, preparedStatement, connection);
		}
		return result;
	} 
	
	/**
	 * 查询通用方法
	 * 由于查询需要返回ResultSet资源
	 * 所以无法在这里关闭全部资源
	 * 所以查询方法不能创建通用方法
	 */

	/**
	 * 关闭所有资源方法
	 */
	public void closeAll(ResultSet resultSet, Statement statement, Connection connection) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
