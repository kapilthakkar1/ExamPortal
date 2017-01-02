package com.ssdi.app.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ssdi.tables.ExamDtls;
import com.ssdi.tables.QuestionDtls;
import com.ssdi.tables.QuestionInterface;
import com.ssdi.tables.UserTxnDtls;

public class TakeExamDAOImpl implements TakeExamDAO{
	
	public List getQuestionList(String examId,Session session)
	{
		String query = " from QuestionDtls ques,ExamDtls exam where ques.examId = exam.examId and ques.examId = :examId ";
		Query hibQuery = session.createQuery(query);
		hibQuery.setString("examId", examId);
		List resList = hibQuery.list();
		return resList;
	}
	public void saveUserTxnData(ArrayList<UserTxnDtls> txnList,Session session)
	{
		for(UserTxnDtls txn:txnList)
		{
			session.save(txn);
			
		}
	}
	
	public boolean checkIfExamTaken(String examId,long userId,Session session)
	{
		boolean examTaken = false;
		String query = "from UserTxnDtls userTxnDtls where userTxnDtls.examId = :examId and userTxnDtls.userId = :userId ";
		Query hibQuery = session.createQuery(query);
		hibQuery.setString("examId", examId);
		hibQuery.setLong("userId", userId);
		List resList = hibQuery.list();
		if(!resList.isEmpty())
		{
			examTaken = true;
		}

		return examTaken;
	}
	
	public ExamDtls getRandomQuestionList(String examId,Session session)
	{
		List resList = getQuestionList( examId, session);
		List<QuestionInterface> questionList = new ArrayList<QuestionInterface>();
		ExamDtls exam = new ExamDtls();
		ExamDtls examTemp = null;
		QuestionDtls quesTemp = null;
		for(int i=0;i<resList.size();i++)
		{
			Object[] row = (Object[])resList.get(i);
			quesTemp = new QuestionDtls();
			quesTemp = (QuestionDtls)row[0]; 
			questionList.add(quesTemp);
			if(i==0)
			{
				//Cannot use the object directly due to hibernate persistence
				examTemp = new ExamDtls();
				examTemp = (ExamDtls)row[1];
				exam.setExamId(examTemp.getExamId());
				exam.setExamName(examTemp.getExamName());
				exam.setNoOfQuestion(examTemp.getNoOfQuestion());
				examTemp = null;
			}
		}
		
		//Generating Random Numbers and Making the Question List
		String generatedNos="";
		Random rand = new Random();
		int tempRand = 0;
		int noOfQues = exam.getNoOfQuestion();
		//Checking if Exam has less question in DB then the specified number of question
		if(noOfQues>questionList.size())
		{
			noOfQues = questionList.size();
		}
		for(int i=0;i<noOfQues;i++)
		{
			do
			{
				tempRand = randInt(0,(noOfQues-1),rand);
			}while(generatedNos.contains(tempRand+""));
			exam.addQuestion(questionList.get(tempRand));
			generatedNos = generatedNos + tempRand;
			tempRand = 0;
		}
		return exam;
	}
	
	public int randInt(int min, int max,Random rand) {

	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}

}
