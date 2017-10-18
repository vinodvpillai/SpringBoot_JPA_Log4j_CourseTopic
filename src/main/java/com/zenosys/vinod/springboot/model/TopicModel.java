/**
 * 
 */
package com.zenosys.vinod.springboot.model;

import java.util.LinkedHashMap;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * This class represents
 * 
 * @author Vinod Pillai - vinodthebest@gmail.com
 * @version
 */
@Entity
@Table(name = "topic")
public class TopicModel {

	private int id;
	private String title;
	private String description;

	private CoursesModel course;

	
	private int course_id;

	
	private LinkedHashMap<Integer, String> courselist = new LinkedHashMap<Integer, String>();

	public TopicModel() {
		super();
	}

	public TopicModel(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	public TopicModel(int id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}

	public TopicModel(String title, String description, CoursesModel course) {
		super();
		this.title = title;
		this.description = description;
		this.course = course;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_course")
	public CoursesModel getCourse() {
		return course;
	}

	public void setCourse(CoursesModel course) {
		this.course = course;
	}

	@Transient
	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	@Transient
	public LinkedHashMap<Integer, String> getCourselist() {
		return courselist;
	}

	public void setCourselist(LinkedHashMap<Integer, String> courselist) {
		this.courselist = courselist;
	}

	public void addToCourseList(int key, String value) {
		this.courselist.put(key, value);
	}

	public void loadCourseFromCourseList(List<CoursesModel> courseList) {

		for (CoursesModel course : courseList) {
			this.courselist.put(course.getId(), course.getTitle());
		}
	}

	@Override
	public String toString() {
		return "TopicModel [id=" + id + ", title=" + title + ", description="
				+ description + ", course=" + course + ", course_id="
				+ course_id + ", courselist=" + courselist + "]";
	}

}
