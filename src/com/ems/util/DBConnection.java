package com.ems.util;
import java.sql.*;

public class DBConnection{
	static Connection conn = null;
	public static Connection getConnection(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:localhost:1521:orcl.168.2.4","system","pass1");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return conn;
	}
}
