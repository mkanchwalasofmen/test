package com.sofmen.spranghib.beans;


public class Student extends BaseBean {

	private static final long serialVersionUID = 5670867510789147506L;
	private Long id;
	private String name;
	private Integer percentage;
	private boolean eligible;

	public Student() {
	}
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPercentage() {
		return this.percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}

	public boolean isEligible() {
		return this.eligible;
	}

	public void setEligible(boolean eligible) {
		this.eligible = eligible;
	}
}
