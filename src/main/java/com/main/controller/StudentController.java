package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.main.entity.Student;
import com.main.exception.StudentException;
import com.main.service.StudentService;


@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	
	StudentService studentService;
	
	@PostMapping("/insertStudent")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) throws StudentException{
		return new ResponseEntity<>(studentService.addStudent(student),HttpStatus.CREATED) ;
	}

   
	@GetMapping("/get/{sid}")
	public ResponseEntity<Student> getStockById(@PathVariable("sid") Integer sid) throws StudentException  {
		return new ResponseEntity<>(studentService.getStudentbyId(sid),HttpStatus.FOUND);
	}
	@PutMapping("/update/{sid}")
   public ResponseEntity<Student>updateStudentbyId(@PathVariable("sid")Integer sid,@RequestBody Student student) throws StudentException{
		return new ResponseEntity<>(studentService.updateStudentbyId(sid, student),HttpStatus.OK);
		
	}

	@DeleteMapping("/delete/{stockId}")
	public ResponseEntity<String> deleteStudentById(@PathVariable("stickId") Integer stockId) throws StudentException {
		return new ResponseEntity<>(studentService.deleteStudentbyId(stockId),HttpStatus.OK);
	}

	
	@GetMapping("/getAllStudent")
	public ResponseEntity<List<Student>> getAllStudent() throws StudentException {
		return new ResponseEntity<>(studentService.getAllStudent(),HttpStatus.FOUND);
	}
	
	}

