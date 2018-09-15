package com.ems.service;

import com.ems.dao.AdminDAOImpl;
import com.ems.dao.IAdminDAO;
import com.ems.exception.EmployeeException;

public class AdminServiceImpl implements IAdminService{

	IAdminDAO adminDAO = null;
	public AdminServiceImpl() {
		
	}
	@Override
	public String loginAdmin(String uname, String pass) throws EmployeeException{
		adminDAO = new AdminDAOImpl();
		return adminDAO.loginAdmin(uname, pass);
	}
	
}
