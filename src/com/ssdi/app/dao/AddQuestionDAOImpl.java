package com.ssdi.app.dao;

import org.hibernate.Session;

import com.ssdi.tables.QuestionDtls;

public class AddQuestionDAOImpl implements AddQuestionDAO
{
	
	public QuestionDtls saveQuestion(QuestionDtls questionDtls,Session session)
	{
		session.save(questionDtls);
		return questionDtls;
	}
}