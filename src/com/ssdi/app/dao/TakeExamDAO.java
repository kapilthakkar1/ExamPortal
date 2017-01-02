package com.ssdi.app.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ssdi.tables.ExamDtls;
import com.ssdi.tables.UserDtls;
import com.ssdi.tables.UserTxnDtls;

public interface TakeExamDAO {
	
	public List getQuestionList(String examId,Session session);
	public void saveUserTxnData(ArrayList<UserTxnDtls> txnList,Session session);	
	public boolean checkIfExamTaken(String examId,long userId,Session session);
	public ExamDtls getRandomQuestionList(String examId,Session session);
	public int randInt(int min, int max,Random rand) ;
}
