package com.SMS.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;

	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public AddStudentResponsedto addStudent(StudentRequestdto request) {

		AddStudentResponsedto response = new AddStudentResponsedto();

		if (request == null) {
			response.setMessage("Request object not found!!");
			return response;
		}

		if (request.getName() == null || request.getName().isBlank() || request.getBranch() == null
				|| request.getBranch().isBlank() || request.getSemester() <= 0 || request.getYear() <= 0) {

			response.setMessage("Invalid input");
			return response;
		}

		Student student = new Student();

		student.setName(request.getName());
		student.setBranch(request.getBranch());
		student.setSemester(request.getSemester());
		student.setYear(request.getYear());
		student.setCreatedAt(LocalDateTime.now());

		Student savedStudent = studentRepository.save(student);

		response.setId(savedStudent.getId());
		response.setName(savedStudent.getName());
		response.setBranch(savedStudent.getBranch());
		response.setSemester(savedStudent.getSemester());
		response.setYear(savedStudent.getYear());
		response.setCreatedAt(savedStudent.getCreatedAt());
		response.setMessage("Student saved in DB");

		return response;
	}

	private StudentResponsedto setStudentResponsedto(Student student) {

		StudentResponsedto response = new StudentResponsedto();

		response.setId(student.getId());
		response.setName(student.getName());
		response.setBranch(student.getBranch());
		response.setSemester(student.getSemester());
		response.setYear(student.getYear());
		response.setCreatedAt(student.getCreatedAt());
		response.setMessage("Student found");

		return response;
	}

	@Override
	public StudentResponsedto getStudentById(int id) {

		Optional<Student> optionalStudent = studentRepository.findById(id);

		if (optionalStudent.isEmpty()) {

			StudentResponsedto response = new StudentResponsedto();
			response.setMessage("Student not found!!");

			return response;
		}

		return setStudentResponsedto(optionalStudent.get());
	}

	@Override
	public List<StudentResponsedto> getAllStudents() {

		List<StudentResponsedto> response = new ArrayList<>();

		List<Student> students = studentRepository.findAll();

		for (Student student : students) {
			response.add(setStudentResponsedto(student));
		}

		return response;
	}

	@Override
	public StudentResponsedto updateStudent(int id, StudentRequestdto request) {

		StudentResponsedto response = new StudentResponsedto();

		if (request == null) {
			response.setMessage("Request object not found!!");
			return response;
		}

		if (request.getName() == null || request.getName().isBlank() || request.getBranch() == null
				|| request.getBranch().isBlank() || request.getSemester() <= 0 || request.getYear() <= 0) {

			response.setMessage("Invalid input");
			return response;
		}

		Optional<Student> optionalStudent = studentRepository.findById(id);

		if (optionalStudent.isEmpty()) {
			response.setMessage("Student not found");
			return response;
		}

		Student student = optionalStudent.get();

		student.setName(request.getName());
		student.setBranch(request.getBranch());
		student.setSemester(request.getSemester());
		student.setYear(request.getYear());

		Student savedStudent = studentRepository.save(student);

		return setStudentResponsedto(savedStudent);
	}

	@Override
	public StudentResponsedto deleteStudent(int id) {

		StudentResponsedto response = new StudentResponsedto();

		Optional<Student> optionalStudent = studentRepository.findById(id);

		if (optionalStudent.isEmpty()) {
			response.setMessage("Student not found");
			return response;
		}

		Student student = optionalStudent.get();

		studentRepository.delete(student);

		response = setStudentResponsedto(student);
		response.setMessage("Deleted!!");

		return response;
	}
}