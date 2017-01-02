package com.ssdi.app.business;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import com.ssdi.app.dao.CertificationDAO;
import com.ssdi.app.dao.CertificationDAOImpl;
import com.ssdi.main.BusinessClassInterface;
import com.ssdi.tables.UserDtls;
import com.ssdi.util.RequestUtils;

public class Certification implements BusinessClassInterface {

	@Override
	public String businessMethod(HttpServletRequest request, Session session)
			throws Exception {
		String actionName = RequestUtils.getStringFromRequest(request,
				"actionName");
		// request.setAttribute("sentthis", "1");
		String pageName = "";

		if (actionName.equals("certification")) {
			UserDtls user = (UserDtls) request.getSession().getAttribute(
					"userDtls");
			long userId = user.getUserId();
			long testExamId =Long.parseLong( RequestUtils.getStringFromRequest(request, "examId"));
			int correct = 0;
			CertificationDAO dao = new CertificationDAOImpl();
			float percentage = dao.getPercentage(userId, testExamId, session);
			boolean isPass = dao
					.isPass(userId, testExamId, session, percentage);
			float percentile = dao.getPercentile(userId, testExamId, session,
					percentage);
			System.out.print("percentage: " + percentage + " isPass: " + isPass
					+ " percentile: " + percentile);
			request.setAttribute("percentage", percentage);
			request.setAttribute("percentile", percentile);
			request.setAttribute("ispass", isPass);
			pageName = "CertificationPage";
		}
		return pageName;

	}

}
