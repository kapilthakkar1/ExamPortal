package com.ssdi.app.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ssdi.tables.CertificationDtls;
import com.ssdi.tables.ExamDtls;
public class EditExamDAOImpl implements EditExamDAO  {
	
	public ExamDtls editExam(ExamDtls examDtls,Session session)
	{
		session.update(examDtls);
		return examDtls;
	}

	@Override
	public ExamDtls fetchExam(long examId, Session session) {
		ExamDtls examDtls = null;		
		String query = "from ExamDtls ed where ed.examId = " + examId;
		Query hibQuery = session.createQuery(query);
		List resList = hibQuery.list();
		if(!resList.isEmpty())
		{
			examDtls = (ExamDtls)resList.get(0);
		}
		return examDtls;
	}

}



