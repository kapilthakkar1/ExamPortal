package com.ssdi.tables;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@GenericGenerator(name="increment" , strategy="increment")
@Table(name="ep_question_dtls")
public class QuestionDtls implements Serializable,QuestionInterface {


	@Id @GeneratedValue(generator="increment")
	   @Column(name = "question_num")
	   private long questionNum;
	
	@Column(name = "question_name")
	   private String quesName;
	
	@Column(name = "question_opt1")
	   private String quesOpt1;
	
	@Column(name = "question_opt2")
	   private String quesOpt2;
	
	@Column(name = "question_opt3")
	   private String quesOpt3;
	
	@Column(name = "question_opt4")
	   private String quesOpt4;
	
	@Column(name = "question_correct_opt")
	   private String quesCorrectOpt;

	@Column(name = "question_time")
	   private long time;
	
	@Column(name = "exam_id")
	   private long examId;
	
	@Column(name = "seq_no")
	   private Long seqNo;

	public long getQuestionNum() {
		return questionNum;
	}

	public void setQuestionNum(long questionNum) {
		this.questionNum = questionNum;
	}

	public String getQuesName() {
		return quesName;
	}

	public void setQuesName(String quesName) {
		this.quesName = quesName;
	}

	public String getQuesOpt1() {
		return quesOpt1;
	}

	public void setQuesOpt1(String quesOpt1) {
		this.quesOpt1 = quesOpt1;
	}

	public String getQuesOpt2() {
		return quesOpt2;
	}

	public void setQuesOpt2(String quesOpt2) {
		this.quesOpt2 = quesOpt2;
	}

	public String getQuesOpt3() {
		return quesOpt3;
	}

	public void setQuesOpt3(String quesOpt3) {
		this.quesOpt3 = quesOpt3;
	}

	public String getQuesOpt4() {
		return quesOpt4;
	}

	public void setQuesOpt4(String quesOpt4) {
		this.quesOpt4 = quesOpt4;
	}

	public String getQuesCorrectOpt() {
		return quesCorrectOpt;
	}

	public void setQuesCorrectOpt(String quesCorrectOpt) {
		this.quesCorrectOpt = quesCorrectOpt;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public long getExamId() {
		return examId;
	}

	public void setExamId(long examId) {
		this.examId = examId;
	}

	public long getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(long seqNo) {
		this.seqNo = seqNo;
	}	
	public void setSeqNo(Long seqNo) {
		this.seqNo = seqNo;
	}	


	
	
}
