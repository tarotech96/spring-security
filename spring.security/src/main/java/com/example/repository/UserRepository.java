/**
 * 
 */
package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.User;

/**
 * @author nguye
 *
 */

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByUserName(String userName);

}
