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
@Table(name="topic")
public class TopicModel {

	private int id;
	private String title;
	private String description;

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

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	@Override
	public String toString() {
		return "TopicModel [id=" + id + ", title=" + title + ", description="
				+ description + "]";
	}

}
