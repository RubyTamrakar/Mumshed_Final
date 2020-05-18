package edu.mum.mumsched.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.mumsched.model.Student;


@Repository("studentRepository")
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	@Query("select s from edu.mum.mumsched.model.Student s join s.user u where u.username = :userName")
	public Student findByUsername(@Param("userName") String userName);
}