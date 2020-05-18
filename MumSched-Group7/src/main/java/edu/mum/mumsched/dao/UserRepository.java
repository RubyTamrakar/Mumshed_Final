package edu.mum.mumsched.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.mumsched.enums.RoleEnum;
import edu.mum.mumsched.model.User;


@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    
	@Query("SELECT u FROM User u WHERE u.role = :role")
	List<User> findByRole(@Param("role") RoleEnum role);
}