package com.ems.dao;

import com.ems.exception.EmployeeException;

public interface IAdminDAO{
	String loginAdmin(String uname,String pass) throws EmployeeException;
}
