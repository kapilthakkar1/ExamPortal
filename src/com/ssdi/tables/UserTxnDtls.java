package com.ssdi.tables;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@GenericGenerator(name="increment" , strategy="increment")
@Table(name="ep_user_exam_txn_dtls")
public class UserTxnDtls{

	@Id @GeneratedValue(generator="increment")
	   @Column(name = "exam_txn_id")
	   private long examTxnId;
	
	@Column(name = "exam_id")
	   private long examId;
	
	@Column(name = "user_id")
	   private long userId;
	
	@Column(name = "question_num")
	   private long quesNum;
	
	@Column(name = "option_given")
	   private String opGiven;
	
	@Column(name = "option_correct")
	   private String opCorrect;
	
	@Column(name = "create_date")
	   private Date crtDate;
	
	@Column(name = "update_date")
	   private Date updDate;

	public long getExamTxnId() {
		return examTxnId;
	}

	public void setExamTxnId(long examTxnId) {
		this.examTxnId = examTxnId;
	}

	public long getExamId() {
		return examId;
	}

	public void setExamId(long examId) {
		this.examId = examId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getQuesNum() {
		return quesNum;
	}

	public void setQuesNum(long quesNum) {
		this.quesNum = quesNum;
	}

	public String getOpGiven() {
		return opGiven;
	}

	public void setOpGiven(String opGiven) {
		this.opGiven = opGiven;
	}

	public String getOpCorrect() {
		return opCorrect;
	}

	public void setOpCorrect(String opCorrect) {
		this.opCorrect = opCorrect;
	}

	public Date getCrtDate() {
		return crtDate;
	}

	public void setCrtDate(Date crtDate) {
		this.crtDate = crtDate;
	}

	public Date getUpdDate() {
		return updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}
	
	

}
