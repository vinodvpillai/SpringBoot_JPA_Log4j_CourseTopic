/**
 * 
 */
package com.zenosys.vinod.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zenosys.vinod.springboot.model.StudentModel;

/**
 * This class represents
 * 
 * @author Vinod Pillai - vinodthebest@gmail.com
 * @version
 */
public interface StudentRepository extends JpaRepository<StudentModel, Integer>{

}
