package com.ssdi.app.dao;

import java.util.List;

import org.hibernate.Session;

public interface ViewCertificatesDAO {
	public List getCertificates(Session session,long userId);

}
