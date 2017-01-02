package com.ssdi.tables;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@GenericGenerator(name = "increment", strategy = "increment")
@Table(name = "ep_certification_dtls")
public class CertificationDtls {

	@Column(name = "exam_id")
	private long examId;

	@Column(name = "user_id")
	private long userId;

	@Id
	@GeneratedValue(generator = "increment")
	@Column(name = "cert_id")
	private long certId;

	@Column(name = "date")
	private Date examDate;

	@Column(name = "percentage")
	private float percentage;

	@Column(name = "certificateName")
	private String certificationName;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getCertId() {
		return certId;
	}

	public void setCertId(long certId) {
		this.certId = certId;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public String getCertificationName() {
		return certificationName;
	}

	public void setCertificationName(String certificationName) {
		this.certificationName = certificationName;
	}

	public long getExamId() {
		return examId;
	}

	public void setExamId(long examId) {
		this.examId = examId;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

}
