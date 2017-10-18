/**
 * 
 */
package com.zenosys.vinod.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zenosys.vinod.springboot.model.CoursesModel;

/**
 * This Interface - Course JPA Operation
 * 
 * @author Vinod Pillai - vinodthebest@gmail.com
 * @version 1.0
 */
public interface CourseRepository extends JpaRepository<CoursesModel, Integer>{

}
