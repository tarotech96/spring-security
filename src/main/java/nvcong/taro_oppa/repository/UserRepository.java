/**
 * 
 */
package nvcong.taro_oppa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nvcong.taro_oppa.entities.User;

/**
 * @author Taro
 *	User Repository Class
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value = "SELECT * FROM users u WHERE u.email =:email", nativeQuery = true)
	public User findByEmail(@Param("email") String email);
	
	@Query(value ="SELECT * FROM users u ORDER BY u.fullname =:fullName ASC", nativeQuery = true)
	public List<User> sortByName(@Param("fullName") String fullName);
	
	@Query(value ="SELECT * FROM users u WHERE u.fullname LIKE CONCAT('%',:fullname,'%')", nativeQuery = true)
	public List<User> searchByName(@Param("fullname") String fullname);

}
