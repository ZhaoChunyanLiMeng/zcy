package com.lanqiao.reflection;

public class student {
	private String stuName;
	private int stuAge;
	private int stuno;

	@Override
	public String toString() {
		return "Student [stuName=" + stuName + ", stuAge=" + stuAge + ", stuno=" + stuno + "]";
	}

	public student(){}

	public student(String stuName, int stuAge, int stuno) {
		super();
		this.stuName = stuName;
		this.stuAge = stuAge;
		this.stuno = stuno;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getStuAge() {
		return stuAge;
	}

	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}

	public int getStuno() {
		return stuno;
	}

	public void setStuno(int stuno) {
		this.stuno = stuno;
	}

	
	
}
