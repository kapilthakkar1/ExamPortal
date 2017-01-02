package com.ssdi.app.business;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import com.ssdi.app.dao.LoginDAO;
import com.ssdi.app.dao.LoginDAOImpl;
import com.ssdi.main.BusinessClassInterface;
import com.ssdi.tables.UserDtls;
import com.ssdi.util.RequestUtils;


public class Login implements BusinessClassInterface {
	
	
	public String businessMethod(HttpServletRequest request,Session session) throws Exception
	{
		String actionName=RequestUtils.getStringFromRequest(request, "actionName");
		String email=RequestUtils.getStringFromRequest(request, "email");
		String encPwd=RequestUtils.getStringFromRequest(request, "encPwd");
		request.setAttribute("sentthis", "1");
		String pageName = "";
		
		if(actionName.equals("login"))
		{
			LoginDAO loginDAO = new LoginDAOImpl();
			UserDtls userDtls=loginDAO.authenticateLogin(email, encPwd, session);
			if(userDtls==null)
			{
				request.setAttribute("homeMessage", "UserName / Password Incorrect");
				pageName = "HomePage";
			}
			else
			{
				request.setAttribute("userDtls",userDtls);
				request.getSession().setAttribute("userDtls",userDtls);
				request.setAttribute("isFirst", "yes");
				pageName = "welcome";
			}
			
		}
		else if (actionName.equals("logout"))
		{
			request.getSession().removeAttribute("userDtls");
			pageName = "HomePage";
		}
		else if (actionName.equals("home"))
		{
			pageName = "welcome";
		}
		return pageName;
	}

}
