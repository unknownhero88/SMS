package com.SMS.demo;

import java.time.LocalDateTime;

public class AddStudentResponsedto {
	private int id;
	private String name;
	private String branch;
	private int year;
	private int semester;
	private String message;
	private LocalDateTime createdAt;

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getBranch() {
		return branch;
	}

	public int getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public String getName() {
		return name;
	}

	public int getSemester() {
		return semester;
	}

	public int getYear() {
		return year;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
