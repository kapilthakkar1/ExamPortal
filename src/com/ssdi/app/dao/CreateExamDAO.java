package com.ssdi.app.dao;

import org.hibernate.Session;

import com.ssdi.tables.ExamDtls;
	public interface CreateExamDAO {
		public ExamDtls createexam(ExamDtls examDtls,Session session);
	}


