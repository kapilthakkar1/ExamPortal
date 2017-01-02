package com.ssdi.app.business;

import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import com.ssdi.app.dao.SignUpDAO;
import com.ssdi.app.dao.SignUpDAOImpl;
import com.ssdi.main.BusinessClassInterface;
import com.ssdi.tables.UserDtls;
import com.ssdi.util.RequestUtils;

public class SignUp implements BusinessClassInterface {


	@Override
	public String businessMethod(HttpServletRequest request, Session session)
			throws Exception {
		
		//String Userid=RequestUtils.getStringFromRequest(request, "Userid");
		String actionName=RequestUtils.getStringFromRequest(request, "actionName");
		String pageName = "";
		if(actionName.equals("signup"))
		{
		String email=RequestUtils.getStringFromRequest(request, "emailS");
		String encPwd=RequestUtils.getStringFromRequest(request, "encPwd2");
		String DOB=RequestUtils.getStringFromRequest(request, "DOB");
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date dobDate = (Date) sdf.parse(DOB);
		request.setAttribute("sentthis", "1");
		
		UserDtls userDtls = new UserDtls();
		userDtls.setEmail(email);
		userDtls.setEncPwd(encPwd);
		userDtls.setRole(1L);
		userDtls.setCrtDate(new Date());
		userDtls.setDob(dobDate);
		SignUpDAO signUpDAO = new SignUpDAOImpl();
		signUpDAO.userRegistration(userDtls, session);
		request.setAttribute("homeMessage", "Registration Successful");
		pageName = "HomePage";
		}
		else if (actionName.equals("checkEmail"))
		{
			String email=RequestUtils.getStringFromRequest(request, "emailS");
			SignUpDAO signUpDAO = new SignUpDAOImpl();
			pageName = signUpDAO.checkEmail(email, session);
		}
		// TODO Auto-generated method stub
		return pageName;
	}
 
}
