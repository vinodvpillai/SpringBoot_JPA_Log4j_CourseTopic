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

import com.zenosys.vinod.springboot.model.CoursesModel;
import com.zenosys.vinod.springboot.service.CourseService;

/**
 * This class Course controller class - Manage all the course related operation
 * This website will have all the request - Course related operation.
 * 
 * @author Vinod Pillai - vinodthebest@gmail.com
 * @version 1.0
 */
@Controller
public class CourseController {

	private static final Logger logger = LogManager
			.getLogger(CourseController.class.getName());
	@Autowired
	private CourseService courseService;

	@GetMapping(value = "/courses/{id}")
	public String getCourse(@PathVariable int id, Model model,
			RedirectAttributes redirect) {
		logger.debug("Entered into getCourse() ");
		CoursesModel courses = courseService.findCourseById(id);
		if (courses != null) {
			logger.debug("Successfully found the Course by ID - getCourse()");
			model.addAttribute("courses", courses);
			return "view-course";
		}
		logger.error("Error in finding the Course by ID - getCourse()");
		redirect.addFlashAttribute("errormsg",
				"Please check the Course ID no record found");
		return "redirect:/courses";
	}

	@GetMapping(value = "/courses")
	public String getAllCourses(Model model) {

		logger.debug("Entered into getAllCourses() ");
		List<CoursesModel> coursesList = courseService.findAllCourses();
		if (coursesList != null && coursesList.size() > 0) {
			logger.debug("Course found inside getAllCourses() and size:"
					+ coursesList.size());
			model.addAttribute("courseslist", coursesList);
		} else {
			logger.warn("Course not found inside getAllCourses()");
			model.addAttribute("error-msg",
					"Please add some courses no record found!");
		}
		return "courses";
	}

	@GetMapping(value = "/courses/create")
	public String addNewCourse(Model model) {
		logger.debug("Entering addNewCourse() ");
		model.addAttribute("courses", new CoursesModel());
		return "create-course";
	}

	@PostMapping(value = "/courses/save")
	public String saveCourse(@ModelAttribute CoursesModel courses,
			RedirectAttributes redirect) {
		logger.debug("Entering saveCourse() ");
		CoursesModel coursesRel = courseService.createNewCourse(courses);
		if (coursesRel != null) {
			logger.debug("Successfully added the Course - saveCourse() ");
			redirect.addFlashAttribute("successmsg",
					"Courses added successfully");
			return "redirect:/courses";
		}
		logger.error("Not able to add the Course - saveCourse() ");
		redirect.addFlashAttribute("errormsg",
				"Sorry some error occured in adding Coures");
		return "create-course";
	}

	@GetMapping(value = "/courses/edit/{id}")
	public String getCourseForEdit(@PathVariable int id, Model model,
			RedirectAttributes redirect) {
		logger.debug("Entering getCourseForEdit() ");
		CoursesModel coursesRel = courseService.findCourseById(id);
		if (coursesRel != null) {
			logger.debug("Found the Course for editing getCourseForEdit() ");
			model.addAttribute("courses", coursesRel);
			return "edit-course";
		}
		logger.error("Invalid Course ID  - getCourseForEdit() ");
		redirect.addFlashAttribute("errormsg",
				"Please select valid Course ID for Editing Course");
		return "redirect:/courses";
	}

	@PostMapping(value = "/courses/update")
	public String updateCourseDetail(@ModelAttribute CoursesModel courses,
			RedirectAttributes redirect) {
		logger.debug("Entering updateCourseDetail() ");
		if (courseService.updateCourse(courses) != null) {
			logger.debug("Successfully updated the Course - updateCourseDetail() ");
			redirect.addFlashAttribute("sucessmsg",
					"Course Updated successfully.");
			return "redirect:/courses";
		}
		logger.error("Error in updating the Course - updateCourseDetail()");
		return "edit-course";
	}

	@GetMapping(value = "/courses/delete/{id}")
	public String deleteCourseDetail(@PathVariable int id,
			RedirectAttributes redirect) {
		logger.debug("Entering deleteCourseDetail()");
		courseService.deleteCourse(id);
		logger.debug("Successfully deleted the Course - deleteCourseDetail() ");
		redirect.addFlashAttribute("successmsg", "Course Deleted successfully.");
		return "redirect:/courses";
	}

}
