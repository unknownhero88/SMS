package com.SMS.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface StudentService {
	public AddStudentResponsedto addStudent(StudentRequestdto request);
	public StudentResponsedto getStudentById(int id);
	public List<StudentResponsedto> getAllStudents();
	public StudentResponsedto updateStudent(int id,StudentRequestdto request);
	public StudentResponsedto deleteStudent(int id);
}
