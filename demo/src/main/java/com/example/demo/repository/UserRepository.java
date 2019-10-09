/**
 * 
 */
package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;

/**
 * @author nguye
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "SELECT * FROM users u WHERE u.username=:userName", nativeQuery = true)
	Optional<User> loadByUserName(@Param("userName") String userName);
}
