package com.ssdi.app.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ssdi.tables.CertificationDtls;

public class ViewCertificatesDAOImpl implements ViewCertificatesDAO {
	public List getCertificates(Session session,long userId) {
		CertificationDtls certificatedtls = null;		
		String query = "from CertificationDtls cd where cd.userId = " +userId;
		Query hibQuery = session.createQuery(query);
		List resList = hibQuery.list();
		return resList;
	}	
}
