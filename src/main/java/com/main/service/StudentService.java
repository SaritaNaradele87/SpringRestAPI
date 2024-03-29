package com.main.service;

import java.util.List;

import com.main.entity.Student;
import com.main.exception.StudentException;


public interface StudentService {
	Student  addStudent(Student student) throws StudentException;
	 Student getStudentbyId(Integer sid)throws StudentException;
	   Student updateStudentbyId(Integer sid,Student student)throws StudentException;
	   List<Student>getAllStudent()throws StudentException;
	    String deleteStudentbyId(Integer sid)throws StudentException;
	
  
   
   
   
   
}
