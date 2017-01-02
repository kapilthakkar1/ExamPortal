package com.ssdi.app.business;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ssdi.main.BusinessClassInterface;
import com.ssdi.tables.MyTest;
import com.ssdi.util.RequestUtils;


public class HomePage implements BusinessClassInterface {
	
	
	public String businessMethod(HttpServletRequest request,Session session) throws Exception
	{
		String actionName=RequestUtils.getStringFromRequest(request, "actionName");
		request.setAttribute("sentthis", "1");
		String pageName = "";
		
		if(actionName.equals("homePage"))
		{
			pageName = "HomePage";
		}
		return pageName;
	}

}
