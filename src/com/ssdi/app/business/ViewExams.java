package com.ssdi.app.business;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import com.ssdi.app.dao.ViewExamsDAO;
import com.ssdi.app.dao.ViewExamsDAOImpl;
import com.ssdi.main.BusinessClassInterface;
import com.ssdi.util.RequestUtils;

public class ViewExams implements BusinessClassInterface {

	@Override
	public String businessMethod(HttpServletRequest request, Session session)
			throws Exception {
		String actionName = RequestUtils.getStringFromRequest(request,
				"actionName");
		System.out.println("controller: " + actionName);
		String pageName = "";

		if (actionName.equals("exams")) {
			ViewExamsDAO dao = new ViewExamsDAOImpl();
			List result = (List) dao.getExams(session);
			request.setAttribute("examlist", result);
			pageName = "ExamsPage";
		}
		if (actionName.equals("viewExams")) {
			System.out.println("Controller inside if");
			ViewExamsDAO dao = new ViewExamsDAOImpl();
			String searchStr = RequestUtils.getStringFromRequest(request,
					"searchStr");
			List result = (List) dao.getExamAdmin(searchStr, session);// (session);
			request.setAttribute("examlist", result);
			request.setAttribute("searchStr", searchStr);
			pageName = "ExamsPage";
		}
		return pageName;
	}

}
