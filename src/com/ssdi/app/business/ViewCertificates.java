package com.ssdi.app.business;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import com.ssdi.app.dao.ViewCertificatesDAO;
import com.ssdi.app.dao.ViewCertificatesDAOImpl;
import com.ssdi.main.BusinessClassInterface;
import com.ssdi.tables.UserDtls;
import com.ssdi.util.RequestUtils;

public class ViewCertificates implements BusinessClassInterface {

	@Override
	public String businessMethod(HttpServletRequest request, Session session)
			throws Exception {
		String actionName=RequestUtils.getStringFromRequest(request, "actionName");
		//request.setAttribute("sentthis", "1");
		String pageName = "";
		
		if(actionName.equals("exams"))
		{
			ViewCertificatesDAO dao = new ViewCertificatesDAOImpl();
			List result = null;
			UserDtls userDtls = (UserDtls)request.getSession().getAttribute("userDtls");
			result = dao.getCertificates(session,userDtls.getUserId());
			request.setAttribute("certificatelist", result);
			pageName = "certificatesPage";
		}
		return pageName;
	}

}