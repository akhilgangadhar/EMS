package com.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.ems.exception.EmployeeException;
import com.ems.util.DBConnection;

public class AdminDAOImpl implements IAdminDAO{
	Logger logger = Logger.getRootLogger();
	
	public AdminDAOImpl(){
		PropertyConfigurator.configure("resources/log4j.properties");
	}
	
	@Override
	public String loginAdmin(String uname, String pass) throws EmployeeException {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = conn.prepareStatement(QueryMapper.FETCH_PWD);
			preparedStatement.setString(1,uname);
			resultSet = preparedStatement.executeQuery();
			System.out.println(resultSet);
			if(resultSet == null){
				return "Username not found";
			}else {
				resultSet.next();
				String pwd = resultSet.getString(1);
				String id = resultSet.getString(2);
				System.out.println(pwd);
				System.out.println(id);
				if(pass.equals(pwd)){
					return id;
				}else {
					return "Incorrect password";
				}
			}
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
			throw new EmployeeException("Technical problem");
		}finally {
			try {
				resultSet.close();
				preparedStatement.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
				throw new EmployeeException("Error in closing db connection");
			}
		}
	}
}
