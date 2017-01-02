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
@Table(name="ep_user_dtls")
public class UserDtls {

	@Id @GeneratedValue(generator="increment")
	   @Column(name = "user_id")
	   private long userId;
	
	@Column(name = "email")
	   private String email;
	
	@Column(name = "password")
	   private String encPwd;
	
	@Column(name = "dob")
	   private Date dob;
	
	@Column(name = "role")
	   private long role;
	
	@Column(name = "crt_date")
	   private Date crtDate;
	
	@Column(name = "upd_date")
	   private Date updDate;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEncPwd() {
		return encPwd;
	}

	public void setEncPwd(String encPwd) {
		this.encPwd = encPwd;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public long getRole() {
		return role;
	}

	public void setRole(long role) {
		this.role = role;
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
