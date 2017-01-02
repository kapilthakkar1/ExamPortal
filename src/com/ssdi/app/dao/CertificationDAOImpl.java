package com.ssdi.app.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ssdi.tables.CertificationDtls;
import com.ssdi.tables.ExamDtls;
import com.ssdi.tables.UserTxnDtls;

public class CertificationDAOImpl implements CertificationDAO {

	@Override
	public float getPercentage(long userId, long examId, Session session) {

		List finalresult;
		String certName;
		int cutoff = 0;
		String query = " from UserTxnDtls where userId = " + userId
				+ " and examId = " + examId;
		Query hibQuery = session.createQuery(query);
		List result = hibQuery.list();
		int correct = 0;
		for (int i = 0; i < result.size(); i++) {
			UserTxnDtls u1 = new UserTxnDtls();
			u1 = (UserTxnDtls) result.get(i);
			System.out.println(u1.getOpGiven() + " and  " + u1.getOpCorrect());
			if (u1.getOpCorrect().equalsIgnoreCase(u1.getOpGiven())) {
				correct++;
			}
		}

		float percent = (correct * 100.0f) / result.size();
		Date d = new Date();
		CertificationDtls details = new CertificationDtls();
		String query1 = "from ExamDtls where examId=" + examId;
		Query hibQuery1 = session.createQuery(query1);
		List result1 = hibQuery1.list();
		ExamDtls e = (ExamDtls) result1.get(0);
		if(percent>=e.getcutoff())
		{
			String cName = e.getcertificateName();
			details.setCertificationName(cName);
			
			details.setExamId(examId);
			details.setUserId(userId);
			details.setPercentage(percent);
			// details.setCertId("");
			details.setExamDate(d);
			session.save(details);
		}
		query = "from ExamDtls where exam_id=" + examId;
		hibQuery = session.createQuery(query);
		List results = hibQuery.list();
		certName = ((ExamDtls) results.get(0)).getcertificateName();
		cutoff = ((ExamDtls) results.get(0)).getcutoff();

		return percent;
	}

	@Override
	public float getPercentile(long userId, long examId, Session session,
			float percent) {
		String query = "from CertificationDtls where exam_id=" + examId;
		System.out.println(query);
		Query q = session.createQuery(query);
		List results = q.list();
		ArrayList<Float> percentages = new ArrayList<Float>();
		for (int i = 0; i < results.size(); i++) {
			float percent1 = ((CertificationDtls) results.get(i))
					.getPercentage();
			percentages.add(percent1);
		}
		Collections.sort(percentages);
		float max = (float) percentages.get(percentages.size() - 1);
		float percentile = (percent / max) * 100;

		return percentile;
	}

	@Override
	public boolean isPass(long userId, long examId, Session session,
			float percentage) {
		// TODO Auto-generated method stub
		String query = "from ExamDtls where exam_id=" + examId;
		Query hibQuery = session.createQuery(query);
		List results = hibQuery.list();
		int cutoff = ((ExamDtls) results.get(0)).getcutoff();
		if (percentage >= cutoff)
			return true;
		else
			return false;
	}

	@Override
	public String getCertName(long userId, long examId, Session session) {

		String query = "from ExamDtls where exam_id=" + examId;
		Query hibQuery = session.createQuery(query);
		List results = hibQuery.list();
		String certName = ((ExamDtls) results.get(0)).getcertificateName();
		return certName;
	}
}
