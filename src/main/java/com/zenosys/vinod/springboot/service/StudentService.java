/**
 * 
 */
package com.zenosys.vinod.springboot.service;

import java.util.List;

import com.zenosys.vinod.springboot.model.StudentModel;

/**
 * This class represents
 * 
 * @author Vinod Pillai - vinodthebest@gmail.com
 * @version
 */
public interface StudentService {

	public StudentModel registerNewStudent(StudentModel student);
	public StudentModel editStudentDetails(StudentModel student);
	public void deleteStudentById(int id);
	public StudentModel findStudentById(int id);
	public List<StudentModel> findAllStudent();
	
	//public StudentModel enrollStudentForCourse(StudentModel student,CourseModel course);
	
}
