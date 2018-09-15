package com.ems.test;

import java.sql.Connection;
import java.sql.SQLException;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ems.exception.EmployeeException;
import com.ems.util.DBConnection;


public class DBConnectionTest {
	static Connection dbCon;
	
	@BeforeClass
	public static void initialise(){
		dbCon = null;
	}
	
	@Before
	public void beforeEachTest(){
		System.out.println("----Starting DBConnection Test Case----\n");
	}
	
	@Test
	public void test() throws EmployeeException, SQLException{
		Connection dbCon = DBConnection.getConnection();
		Assert.assertNotNull(dbCon);
	}
	
	@After
	public void afterEachTest(){
		System.out.println("----End of DBConnection Test Case----\n");
	}
	
	@AfterClass
	public static void destroy(){
		System.out.println("\t----End of Tests----");
		dbCon = null;
	}
}

