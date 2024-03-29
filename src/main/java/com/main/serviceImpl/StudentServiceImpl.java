package com.main.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.Student;
import com.main.exception.StudentException;
import com.main.repository.StudentRepository;
import com.main.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository studentRepository;
	@Override
	public Student addStudent(Student student) throws StudentException {
		// TODO Auto-generated method stub
		
	    if (studentRepository.findById(student.getSid()).isPresent()) {
	        throw new StudentException("Student already present with this " + student.getSid());
	    }
		Student saveStudent=studentRepository.save(student);
		return saveStudent;
	}


	
	@Override
	public Student getStudentbyId(Integer sid) throws StudentException {
	    // Find student by ID
	    Optional<Student> opt = studentRepository.findById(sid);
	    if (opt.isEmpty()) {
	        throw new StudentException("Student with ID " + sid + " not found");
	    }
	    return opt.get();
	}


	@Override
	public Student updateStudentbyId(Integer sid, Student updateStudent) throws StudentException {
		// TODO Auto-generated method stub
		Optional<Student>opt=studentRepository.findById(sid);
	 if(opt.isEmpty()) {
			 throw new StudentException(sid +"is not present for Update");
		 }	
	Student existStudent=opt.get();
		existStudent.setFirstName(updateStudent.getFirstName());
		existStudent.setLastName(updateStudent.getLastName());
		existStudent.setBranch(updateStudent.getBranch());
		existStudent.setEmail(updateStudent.getEmail());
		existStudent.setYearOfStudy(updateStudent.getYearOfStudy());
       return existStudent;
	}

	@Override
	public List<Student> getAllStudent() throws StudentException {
	
			// TODO Auto-generated method stub
		List<Student>list=studentRepository.findAll();
		if(list.size()==0) {
			throw new StudentException("No Student Found");
		}
		return list;
	}
	@Override
	public String deleteStudentbyId(Integer sid) throws StudentException {
	    Optional<Student> opt = studentRepository.findById(sid);
	    if (opt.isEmpty()) {
	        throw new StudentException(sid + "Not available for delete");
	    }
	    studentRepository.deleteById(sid);
	    return "Delete successful";
	}


	}
	
