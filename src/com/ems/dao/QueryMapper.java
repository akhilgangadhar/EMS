package com.ems.dao;

public interface QueryMapper {
	String FETCH_PWD = "SELECT password,id from admin where name=?";
}
