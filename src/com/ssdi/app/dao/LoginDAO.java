package com.ssdi.app.dao;

import org.hibernate.Session;

import com.ssdi.tables.UserDtls;

public interface LoginDAO {
	public UserDtls authenticateLogin(String email,String encPwd,Session session);

}


