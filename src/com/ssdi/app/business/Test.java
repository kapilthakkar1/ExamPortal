package com.ssdi.app.business;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ssdi.main.BusinessClassInterface;
import com.ssdi.tables.MyTest;
import com.ssdi.util.RequestUtils;


public class Test implements BusinessClassInterface {
	
	
	public String businessMethod(HttpServletRequest request,Session session) throws Exception
	{
		String actionName=RequestUtils.getStringFromRequest(request, "actionName");
		String pageName = "";
		/*
		String query = "Select * from my_test where test_id = 1";
		Query hiQuery1 = session.createSQLQuery(query);
		List retList = hiQuery1.list();
		
		String query2 = "Select myT from MyTest myT where myT.testId = 1";
		Query hiQuery2 = session.createQuery(query2);
		retList = hiQuery2.list();
		
		MyTest test = (MyTest)retList.get(0);
		test.setName("Shiv_3");
		test = null;
		retList = null;
		*/
		if(actionName.equals("redirect"))
		{
			pageName = "SecondJsp";
		}
		pageName = "SecondJsp";
		request.setAttribute("StringTest", "Test_123");
		//Same way different Operations can be done
		return pageName;
	}

}
