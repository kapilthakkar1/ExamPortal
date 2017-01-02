package com.ssdi.app.dao;

import org.hibernate.Session;

import com.ssdi.tables.QuestionDtls;

public interface AddQuestionDAO {
	public QuestionDtls saveQuestion(QuestionDtls questionDtls,Session session);
}