package com.ems.service;

import com.ems.exception.EmployeeException;

public interface IAdminService {
	String loginAdmin(String uname,String pass) throws EmployeeException;
}
