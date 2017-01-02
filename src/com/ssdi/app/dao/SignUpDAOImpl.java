package com.ssdi.app.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ssdi.tables.UserDtls;

public class SignUpDAOImpl implements SignUpDAO {
	
	public UserDtls userRegistration(UserDtls userDtls,Session session)
	{
		session.save(userDtls);
		return userDtls;
	}

	@Override
	public String checkEmail(String email, Session session) {
		UserDtls userDtls = null;
		String emailInDb = "";
		String query = "from UserDtls ud where ud.email = :user ";
		Query hibQuery = session.createQuery(query);
		hibQuery.setString("user", email);
		List resList = hibQuery.list();
		if(!resList.isEmpty())
		{
			userDtls = new UserDtls();
			userDtls = (UserDtls)resList.get(0);
			emailInDb = userDtls.getEmail();
		}
		return emailInDb;
	}
	

}
