package com.ssdi.app.dao;

import java.util.List;

import org.hibernate.Session;

import com.ssdi.tables.QuestionDtls;

public interface ViewEditQuestionDAO {
	public QuestionDtls editQuestion(QuestionDtls questionDtls,Session session);
	public List viewQuestions(long examId,Session session);
	public void deleteQuestions(long quesNum,Session session);
}