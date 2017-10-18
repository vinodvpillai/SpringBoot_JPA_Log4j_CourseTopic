/**
 * 
 */
package com.zenosys.vinod.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class represents
 * 
 * @author Vinod Pillai - vinodthebest@gmail.com
 * @version
 */

@Entity
@Table(name = "student")
public class StudentModel {

	private int id;
	private String fullname;
	private String emailid;
	private String address;

	//private Set<CoursesModel> courses = new HashSet<CoursesModel>();

	public StudentModel() {
		super();
	}

	public StudentModel(String fullname, String emailid, String address) {
		super();
		this.fullname = fullname;
		this.emailid = emailid;
		this.address = address;
	}

	
//	@Override
//	public String toString() {
//		return "StudentModel [id=" + id + ", fullname=" + fullname
//				+ ", emailid=" + emailid + ", address=" + address
//				+ ", courses=" + courses + "]";
//	}
//
//	public StudentModel(String fullname, String emailid, String address,
//			Set<CoursesModel> courses) {
//		super();
//		this.fullname = fullname;
//		this.emailid = emailid;
//		this.address = address;
//		this.courses = courses;
//	}

	@Override
	public String toString() {
		return "StudentModel [id=" + id + ", fullname=" + fullname
				+ ", emailid=" + emailid + ", address=" + address + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "student_courses", joinColumns = @JoinColumn(name = "fk_student", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "fk_course", referencedColumnName = "id"))
//	public Set<CoursesModel> getCourses() {
//		return courses;
//	}
//
//	public void setCourses(Set<CoursesModel> courses) {
//		this.courses = courses;
//	}

	
}
