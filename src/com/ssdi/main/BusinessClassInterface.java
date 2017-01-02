package com.ssdi.main;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

public interface BusinessClassInterface {
	
	public String businessMethod(HttpServletRequest request,Session session) throws Exception;

}
