package com.ssdi.tables;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@GenericGenerator(name="increment" , strategy="increment")
@Table(name="ep_exam_dtls")
public class ExamDtls {

	@Transient
	List<QuestionInterface> questionList = new ArrayList<QuestionInterface>();
	
	@Id @GeneratedValue(generator="increment")
	   @Column(name = "exam_id")
	   private long examId;
	
	@Column(name = "exam_name")
	   private String examName;
	
	@Column(name = "exam_description")
	   private String examDescr;
	
	@Column(name = "crt_date")
	   private Date createdate;
	
	@Column(name = "cutoff")
	   private int cutoff;
	
	@Column(name = "certificateName")
	   private String certificateName;
	
	@Column(name = "no_of_ques")
	   private int noOfQuestion;
	
	public long getExamId() {
		return examId;
	}

	public void setExamId(long examId) {
		this.examId = examId;
	}
	
	public Date getcrtdate() {
		return createdate;
	}

	public void setcrtdate(Date createdate) {
		this.createdate = createdate;
	}
	
	public int getcutoff(){
		return cutoff;
	}
	
	public void setcutoff(int cutoff) {
		this.cutoff = cutoff;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getExamDescr() {
		return examDescr;
	}

	public void setExamDescr(String examDescr) {
		this.examDescr = examDescr;
	}
	
	public String getcertificateName() {
		return certificateName;
	}

	public void setcertificateName(String certificateName) {
		this.certificateName = certificateName;
	}
	
	
	public List<QuestionInterface> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<QuestionInterface> questionList) {
		this.questionList = questionList;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public int getCutoff() {
		return cutoff;
	}

	public void setCutoff(int cutoff) {
		this.cutoff = cutoff;
	}

	public String getCertificateName() {
		return certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}

	public int getNoOfQuestion() {
		return noOfQuestion;
	}

	public void setNoOfQuestion(int noOfQuestion) {
		this.noOfQuestion = noOfQuestion;
	}

	public void addQuestion(QuestionInterface ques)
	{
		questionList.add(ques);
		
	}
	
}	


