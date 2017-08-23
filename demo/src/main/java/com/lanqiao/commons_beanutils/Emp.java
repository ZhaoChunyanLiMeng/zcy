package com.lanqiao.commons_beanutils;

import java.sql.Date;

public class Emp {
	private int id ;
    private String name;
    private double salary;
    private Date date;
    
    @Override
	public String toString() {
		return "Emp 编号=" + id + ", 姓名=" + name + ", 工资=" + salary + ", 生日=" + date + "]";
	}
	public Emp(){}
	public Emp(int id, String name, double salary, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
    
    
}
