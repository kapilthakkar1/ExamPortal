package com.ssdi.app.dao;

import org.hibernate.Session;

public interface CertificationDAO {
	public float getPercentage(long userId, long examId, Session session);

	public float getPercentile(long userId, long examId, Session session,
			float percent);

	public boolean isPass(long userId, long examId, Session session,
			float percentage);

	public String getCertName(long userId, long examId, Session session);
}