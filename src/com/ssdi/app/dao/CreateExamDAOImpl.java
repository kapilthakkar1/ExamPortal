package com.ssdi.app.dao;

import org.hibernate.Session;

import com.ssdi.tables.ExamDtls;

public class CreateExamDAOImpl implements CreateExamDAO  {
	
	public ExamDtls createexam(ExamDtls examDtls,Session session)
	{
		session.save(examDtls);
		return examDtls;
	}

}


