package com.ssdi.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.ssdi.util.BusinessClassUtils;
import com.ssdi.util.HibernateUtil;
import com.ssdi.util.PageReader;
import com.ssdi.util.RequestUtils;

public class MainController extends HttpServlet{
	final static Logger logger = Logger.getLogger(MainController.class);
	public static Map pageDtlsMap = null;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info(" Starting Main Controller");
		//Initializing Session
		Session session =  HibernateUtil.openSession();
		session.beginTransaction();//Take Connection
		String pageName="";
		//END

		//Load page paths
		if(pageDtlsMap==null)
		{
			pageDtlsMap = new HashMap();
			String relativeWebPath = "/config/pageconfig.xml";
			String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
			//String absolut = getServletContext().getContextPath();
			pageDtlsMap = PageReader.getPagePath(absoluteDiskPath);
		}
		//END
		try
		{
			//Getting required values from Register
			String classId = RequestUtils.getStringFromRequest(request, "classId");
			String ajaxRequest = RequestUtils.getStringFromRequest(request, "ajax");
			//END
			

			//Getting business class object from ID
			if(! classId.equals(""))
			{
				String className = BusinessClassUtils.getClassNameFromDB(session, classId);
				pageName = BusinessClassUtils.executeBusinessMethod(className, request, session);
				//END
			}
			
			
			//Checking if not an Ajax Request
			if(ajaxRequest.equals(""))
			{
				//Redirecting to Error Page
				if(pageName.equals(""))
				{
					pageName = "Error";
				}
				//END
				String pagePath = pageDtlsMap.get(pageName).toString();
				RequestDispatcher rd = request.getRequestDispatcher(pagePath);
				rd.include(request, response);
			}
			//if ajax then returning String response
			else
			{
				response.setContentType("text/html");
				  PrintWriter out = response.getWriter();
				  out.append(pageName);
				  out.close();
			}
		//Redirecting to Page END	

		}
		catch(Exception e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
			//Redirecting to Error Page
			String pagePath = pageDtlsMap.get("Error").toString();
			RequestDispatcher rd = request.getRequestDispatcher(pagePath);
			rd.include(request, response);
			//EMD
		}
		finally
		{
			session.getTransaction().commit();//Commit
			session.close();
		}
	}

}
