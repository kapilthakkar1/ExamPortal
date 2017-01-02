package com.ssdi.util.junit;

import static org.junit.Assert.assertEquals;

import org.hibernate.Session;
import org.junit.Test;

import com.ssdi.util.HibernateUtil;
public class HibernateUtilUT {
	
	Exception ex;
	HibernateUtil hibernate;
	Session session;
	@Test
	   public void testHibernateUtil() throws Exception{
		
		try {
			 hibernate = new HibernateUtil();
			 session = HibernateUtil.openSession();
	    } catch (Exception e) {
	        ex = e;
	    }
	    assertEquals(null,ex);
	   }
	 
	
}
