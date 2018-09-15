package com.ems.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ems.exception.EmployeeException;
import com.ems.service.AdminServiceImpl;
import com.ems.service.IAdminService;

public class AdminTest {
	@Test
	public void loginTest() throws EmployeeException {
		IAdminService ias = null;
		ias = new AdminServiceImpl();
		String s = ias.loginAdmin("system","pass1");
		System.out.println(s);
		assertEquals("1",s);
	}
}
