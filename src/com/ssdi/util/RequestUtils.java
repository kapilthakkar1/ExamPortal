package com.ssdi.util;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {
	
	public static String getStringFromRequest(HttpServletRequest request,String parameter)
	{
		return request.getParameter(parameter)!=null?request.getParameter(parameter):"";
	}

}
