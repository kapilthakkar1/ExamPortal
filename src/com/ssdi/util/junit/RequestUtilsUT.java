package com.ssdi.util.junit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;

import com.ssdi.util.RequestUtils;
public class RequestUtilsUT {
	
	HttpServletRequest request = mock(HttpServletRequest.class); 
	RequestUtils requestUtils = new RequestUtils();
	 @Test
	   public void testGetStringFromRequest() throws Exception{
		 when(request.getParameter("actionName")).thenReturn("login");
	    String param = requestUtils.getStringFromRequest(request, "actionName");
		 assertEquals("login",param);
	   }
	
}
