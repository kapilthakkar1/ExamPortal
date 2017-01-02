package com.ssdi.app.dao;

import org.hibernate.Session;

import com.ssdi.tables.ExamDtls;
	public interface EditExamDAO {
		public ExamDtls editExam(ExamDtls examDtls,Session session);
		public ExamDtls fetchExam(long examId,Session session);
	}
