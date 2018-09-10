package com.ems.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public static  boolean isValidUsername(String un){
		Pattern unPattern=Pattern.compile("^[A-Za-z]{3,}$");
		Matcher unMatcher=unPattern.matcher(un);
		return unMatcher.matches();
	}
	
	public void service(HttpServletRequest req, HttpServletResponse res){
		PrintWriter pw = null;
		String msg = null;
		String uname = req.getParameter("uname");
		String pswd = req.getParameter("pass");
		try {
			pw = res.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isValidUsername(uname)){
			if(uname.equals("system")){
				if(pswd.equals("root")){
					msg = "Login successful";
				}else{
					msg = "Incorrect password";
				}
			}else{
				msg = "Username doesn't exist";
			}
		}else{
			msg = "Username should contain only alphabets";
		}
		pw.println(msg);
	}
}
