package com.ujianjuaracoding.main.model;

public class Karyawan {
	 private int worker_id;
	 private String first_name;
	 private String last_name;
	 private int salary;
	 private String joining_date;
	 private String department;
	 
	 public Karyawan() {
		 
	 }
	 
	 
	public Karyawan(int worker_id, String first_name, String last_name, int salary, String joining_date,
			String department) {
		super();
		this.worker_id = worker_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.salary = salary;
		this.joining_date = joining_date;
		this.department = department;
	}



	public int getWorker_id() {
		return worker_id;
	}
	public void setWorker_id(int worker_id) {
		this.worker_id = worker_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getJoining_date() {
		return joining_date;
	}
	public void setJoining_date(String joining_date) {
		this.joining_date = joining_date;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

}
