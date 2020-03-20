/**
 * 
 */
package nvcong.taro_oppa.security;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import nvcong.taro_oppa.entities.User;

/**
 * @author Taro
 *	class used to generate token when user logged in
 */
@Component
public class JwtGenerator {

	public String generate(User user) {

		Claims claims = Jwts.claims().setSubject(user.getEmail());
		claims.put("userId", String.valueOf(user.getId()));
		claims.put("role", user.getRole());

		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, "TARO_OPPA").compact();

	}

}
