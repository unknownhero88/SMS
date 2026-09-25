package com.SMS.demo;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping
	public ResponseEntity<List<StudentResponsedto>> getAll() {
		List<StudentResponsedto> response = studentService.getAllStudents();

		if (response.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<StudentResponsedto> getByID(@PathVariable int id) {
		StudentResponsedto response = studentService.getStudentById(id);

		if (response.getName() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		return ResponseEntity.ok(response);

	}

	@PostMapping
	public ResponseEntity<AddStudentResponsedto> addStudent(@RequestBody StudentRequestdto request) {
		AddStudentResponsedto response = studentService.addStudent(request);

		if (response.getName() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<StudentResponsedto> updateStudnet(@PathVariable int id,
			@RequestBody StudentRequestdto requestdto) {
		StudentResponsedto response = studentService.updateStudent(id, requestdto);

		if (response.getName() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<StudentResponsedto> deleteStudent(@PathVariable int id) {
		StudentResponsedto response = studentService.deleteStudent(id);

		if (response.getName() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);

	}
}
