package com.ssdi.app.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ssdi.tables.ExamDtls;
import com.ssdi.tables.QuestionDtls;

public class ViewEditQuestionDAOImpl implements ViewEditQuestionDAO{

	@Override
	public QuestionDtls editQuestion(QuestionDtls questionDtls, Session session) {
		session.update(questionDtls);
		return questionDtls;
	}

	@Override
	public List viewQuestions(long examId, Session session) {
		ExamDtls examDtls = null;
		String query = "from QuestionDtls qd where qd.examId = :examId";
		Query hibQuery = session.createQuery(query);
		hibQuery.setLong("examId", examId);
		List resList = hibQuery.list();
		return resList;
	}

	@Override
	public void deleteQuestions(long quesNum, Session session) {
		String query = "delete from QuestionDtls qd where qd.questionNum = :questionNum";
		Query hibQuery = session.createQuery(query);
		hibQuery.setLong("questionNum", quesNum);
		hibQuery.executeUpdate();
		
	}

}
