package com.ssdi.app.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ssdi.tables.ExamDtls;

public class ViewExamsDAOImpl implements ViewExamsDAO {

	@Override
	public List getExams(Session session) {
		ExamDtls examDtls = null;
		String query = "from ExamDtls";
		Query hibQuery = session.createQuery(query);
		List resList = hibQuery.list();
		return resList;
	}

	@Override
	public List getExamAdmin(String searchStr, Session session) {
		// TODO Auto-generated method stub
		ExamDtls examDtls = null;
		String query = "from ExamDtls ed";
		if(!searchStr.equals(""))
		{
			searchStr.toLowerCase();
				query +=" where lower(ed.examName) like :searchStr"   ;
				query += " or lower(ed.examDescr) like :searchStr " ;
		}
		Query hibQuery = session.createQuery(query);
		if(!searchStr.equals(""))
		{
			hibQuery.setParameter("searchStr", "%" + searchStr+ "%");
		}
		List resList = hibQuery.list();
		return resList;
	}
	

}
