package com.ssdi.app.dao;

import java.util.List;

import org.hibernate.Session;

public interface ViewExamsDAO {
	public List getExams(Session session);
	public List getExamAdmin(String searchStr,Session session);

}
