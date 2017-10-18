/**
 * 
 */
package com.zenosys.vinod.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zenosys.vinod.springboot.model.CoursesModel;
import com.zenosys.vinod.springboot.repository.CourseRepository;

/**
 * This class represents Course Service
 * 
 * @author Vinod Pillai - vinodthebest@gmail.com
 * @version
 */
@Service
public class CoursesServiceImpl implements CourseService {

	// private static Logger logger=LogManager.getLogger();
	// private final static String CLASS_NAME="CoursesServiceImpl";

	@Autowired
	CourseRepository courseRepository;

	@Override
	public CoursesModel createNewCourse(CoursesModel coursesModel) {

		CoursesModel courses = courseRepository.save(coursesModel);
		if (courses != null) {
			// logger.info("CoursesServiceImpl - createNewCourse() : Created");
			return courses;
		}
		// logger.error(CLASS_NAME+" createNewCourse :Error in creation");
		return null;
	}

	@Override
	public CoursesModel updateCourse(CoursesModel coursesModel) {
		CoursesModel courses = courseRepository.save(coursesModel);
		if (courses != null) {
			return courses;
		}
		return null;
	}

	@Override
	public void deleteCourse(int course_id) {

		courseRepository.delete(course_id);
	}

	@Override
	public CoursesModel findCourseById(int course_id) {

		return courseRepository.findOne(course_id);
	}

	@Override
	public List<CoursesModel> findAllCourses() {
		return courseRepository.findAll();
	}

}
