/**
 * 
 */
package com.zenosys.vinod.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zenosys.vinod.springboot.model.StudentModel;
import com.zenosys.vinod.springboot.repository.StudentRepository;

/**
 * This class represents
 * 
 * @author Vinod Pillai - vinodthebest@gmail.com
 * @version
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public StudentModel registerNewStudent(StudentModel student) {
		return studentRepository.save(student);
	}

	@Override
	public StudentModel editStudentDetails(StudentModel student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(int id) {
		studentRepository.delete(id);
	}

	@Override
	public StudentModel findStudentById(int id) {
		return studentRepository.findOne(id);
	}

	@Override
	public List<StudentModel> findAllStudent() {
		return studentRepository.findAll();
	}

}
