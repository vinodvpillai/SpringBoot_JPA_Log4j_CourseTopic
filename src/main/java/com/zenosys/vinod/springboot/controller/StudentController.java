/**
 * 
 */
package com.zenosys.vinod.springboot.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zenosys.vinod.springboot.model.StudentModel;
import com.zenosys.vinod.springboot.service.StudentService;

/**
 * This class represents Student Controller
 * 
 * @author Vinod Pillai - vinodthebest@gmail.com
 * @version
 */

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	private static final Logger logger = LogManager
			.getLogger(StudentController.class);

	@GetMapping(value = "/students")
	public String getAllStudents(Model model) {

		logger.debug("Request came for getAllStudents()");
		List<StudentModel> studentList = studentService.findAllStudent();
		if (studentList != null && studentList.size() > 0) {

			logger.debug("Student found - getAllStudents() total students are:"
					+ studentList.size());
			model.addAttribute("studentlist", studentList);
		} else {
			logger.error("Student Not found - getAllStudents()");
			model.addAttribute("errormsg", "No record found!");
		}

		return "students";
	}

	@GetMapping("/students/{id}")
	public String getStudentById(@PathVariable int id, Model model,
			RedirectAttributes redirect) {

		logger.debug("Request came for getStudentById()");
		StudentModel studentModel = studentService.findStudentById(id);
		if (studentModel != null) {
			logger.debug("Found the Student :" + studentModel);
			model.addAttribute("student", studentModel);
			return "view-student";
		}
		logger.error("Invalid Id - getStudentById()");
		redirect.addFlashAttribute("errormsg", "Invalid ID");
		return "redirect:/students";
	}

	@GetMapping("/students/create")
	public String addStudent(Model model) {
		logger.debug("Request came for addStudent()");

		model.addAttribute("student", new StudentModel());
		return "create-student";
	}
	
	@PostMapping(value = "/students/save")
	public String saveStudent(@ModelAttribute StudentModel student,
			RedirectAttributes redirect) {
		logger.debug("Entering saveCourse() ");
		StudentModel studentRel = studentService.registerNewStudent(student);
		if (studentRel != null) {
			logger.debug("Successfully added the Student - saveStudent() ");
			redirect.addFlashAttribute("successmsg",
					"Student added successfully");
			return "redirect:/students";
		}
		logger.error("Not able to add the Student - saveStudent() ");
		redirect.addFlashAttribute("errormsg",
				"Sorry some error occured in adding Student");
		return "create-student";
	}
	
	@GetMapping(value = "/students/edit/{id}")
	public String getStudentForEdit(@PathVariable int id, Model model,
			RedirectAttributes redirect) {
		logger.debug("Entering getStudentForEdit() ");
		StudentModel studentRel = studentService.findStudentById(id);
		if (studentRel != null) {
			logger.debug("Found the Student for editing getCourseForEdit() ");
			model.addAttribute("student", studentRel);
			return "edit-student";
		}
		logger.error("Invalid Student ID  - getStudentForEdit() ");
		redirect.addFlashAttribute("errormsg",
				"Please select valid Student ID for Editing Student");
		return "redirect:/students";
	}
	
	@PostMapping(value = "/students/update")
	public String updateStudentDetail(@ModelAttribute StudentModel student,
			RedirectAttributes redirect) {
		logger.debug("Request came for updateStudentDetail() ");
		if (studentService.editStudentDetails(student) != null) {
			logger.debug("Successfully updated the Student - updateStudentDetail() ");
			redirect.addFlashAttribute("sucessmsg",
					"Student Updated successfully.");
			return "redirect:/students";
		}
		logger.error("Error in updating the Student - updateStudentDetail()");
		return "edit-student";
	}

	@GetMapping(value = "/students/delete/{id}")
	public String deleteStudentDetail(@PathVariable int id,
			RedirectAttributes redirect) {
		logger.debug("Request came for deleteStudentDetail()");
		studentService.deleteStudentById(id);
		logger.debug("Successfully deleted the Student - deleteStudentDetail() ");
		redirect.addFlashAttribute("successmsg", "Student Deleted successfully.");
		return "redirect:/students";
	}
}
