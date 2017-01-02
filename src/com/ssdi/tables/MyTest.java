package com.ssdi.tables;

import javax.persistence.*;

@Entity
@Table(name="my_test")
public class MyTest {

	@Id @GeneratedValue
	   @Column(name = "test_id")
	   private int testId;
	
	@Column(name = "name")
	   private String name;

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
