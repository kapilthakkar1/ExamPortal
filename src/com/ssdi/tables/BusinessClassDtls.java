package com.ssdi.tables;

import javax.persistence.*;

@Entity
@Table(name="business_class_dtls")
public class BusinessClassDtls {

	@Id @GeneratedValue
	   @Column(name = "business_class_dtls_id")
	   private int businessClassDtlsId;
	
	@Column(name = "action_name")
	   private String actionName;
	
	@Column(name = "className")
	   private String className;

	public int getBusinessClassDtlsId() {
		return businessClassDtlsId;
	}

	public void setBusinessClassDtlsId(int businessClassDtlsId) {
		this.businessClassDtlsId = businessClassDtlsId;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	

}
