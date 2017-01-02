package com.ssdi.util;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ssdi.main.BusinessClassInterface;

public class BusinessClassUtils {
	
	public static String executeBusinessMethod(String classDtls,HttpServletRequest request,Session session) throws Exception
	{
		Class retClass = Class.forName(classDtls);
		
		if(!retClass.isAssignableFrom(BusinessClassInterface.class))
		{
			//throw new Exception();
		}
		
		Class[] methodArgs = new Class[2];
		methodArgs[0] = HttpServletRequest.class;
		methodArgs[1] = Session.class;
		Method businessMethod = retClass.getMethod("businessMethod", methodArgs);
		
		String pageName = (String)businessMethod.invoke(retClass.newInstance(),request, session);
		
		return pageName;
	}
	
	public static String getClassNameFromDB(Session session,String classId) throws Exception
	{
		String businessClassQueryStr = "SELECT class_name FROM business_class_dtls where class_id = ";
		businessClassQueryStr += classId;
		Query businessClassQuery = session.createSQLQuery(businessClassQueryStr);
		List businessClassList = businessClassQuery.list();

		String className;
		if(!businessClassList.isEmpty())
		{
			className =businessClassList.get(0).toString();
		}
		else
		{
			throw new Exception();
		}
		return className;
	}

}
