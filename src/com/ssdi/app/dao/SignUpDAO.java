package com.ssdi.app.dao;

import org.hibernate.Session;

import com.ssdi.tables.UserDtls;

public interface SignUpDAO {
	public UserDtls userRegistration(UserDtls userDtls,Session session);
	public String checkEmail(String email,Session session);

}




