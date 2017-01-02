package com.ssdi.app.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ssdi.tables.UserDtls;

public class LoginDAOImpl implements LoginDAO {
	
	public UserDtls authenticateLogin(String email,String encPwd,Session session)
	{
		UserDtls userDtls = null;
		String query = "from UserDtls ud where ud.email = :user and ud.encPwd = :pwd";
		Query hibQuery = session.createQuery(query);
		hibQuery.setString("user", email);
		hibQuery.setString("pwd", encPwd);
		List resList = hibQuery.list();
		if(!resList.isEmpty())
		{
			userDtls = new UserDtls();
			userDtls = (UserDtls)resList.get(0);
		}

		return userDtls;
	}

}
