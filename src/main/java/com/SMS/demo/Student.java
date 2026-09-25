package com.SMS.demo;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String branch;
	private int year;
	private int semester;
	private LocalDateTime createdAt;

	public Student() {
		super();
	}

	public Student(int id, String name, String branch, int year, int semester, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.branch = branch;
		this.year = year;
		this.semester = semester;
		this.createdAt = createdAt;
	}

	public String getBranch() {
		return branch;
	}

	public int getId() {
		return id;
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

	public void setName(String name) {
		this.name = name;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

}
