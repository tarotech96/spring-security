/**
 * 
 */
package com.example.configuration;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.entities.User;
import com.example.repository.UserRepository;

/**
 * @author nguye
 *
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findByUserName(username);
		
		if (!user.isPresent()) {
			user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));
		}

		return user.map(MyUserDetails::new).get();
	}

}
