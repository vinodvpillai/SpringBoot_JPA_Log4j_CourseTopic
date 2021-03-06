/**
 * 
 */
package com.zenosys.vinod.springboot.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * This class Course Model All course related properties are defined over here
 * 
 * @author Vinod Pillai - vinodthebest@gmail.com
 * @version 1.0
 */

@Entity
@Table(name = "courses")
public class CoursesModel {

	private int id;
	private String title;
	private String description;
	private int fees;

	//private Set<StudentModel> students = new HashSet<StudentModel>();

	private List<TopicModel> topicList = new ArrayList<TopicModel>();

	public CoursesModel() {
		super();
	}

	public CoursesModel(String title, String description, int fees) {
		super();
		this.title = title;
		this.description = description;
		this.fees = fees;
	}

	public CoursesModel(int id, String title, String description, int fees) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.fees = fees;
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

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "Courses [id=" + id + ", title=" + title + ", description="
				+ description + ", fees=" + fees + "]";
	}

	@OneToMany(mappedBy = "course")
	public List<TopicModel> getTopicList() {
		return topicList;
	}

	public void setTopicList(List<TopicModel> topicList) {
		this.topicList = topicList;
	}
	
//	@ManyToMany(mappedBy="courses")
//	public Set<StudentModel> getStudents() {
//		return students;
//	}
//
//	public void setStudents(Set<StudentModel> students) {
//		this.students = students;
//	}

}
