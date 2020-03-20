/**
 * 
 */
package nvcong.taro_oppa.security;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import nvcong.taro_oppa.entities.User;

/**
 * @author Taro
 * Class used to validate token
 */

@Component
public class JwtValidator {

	private String secret = "TARO_OPPA";

	public User validate(String token) {
		// TODO Auto-generated method stub
		User user = null;
		try {
			Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
			user = new User();
			user.setEmail(body.getSubject());
			user.setId(Integer.parseInt((String) body.get("userId")));
			user.setRole((String) body.get("role"));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

		return user;

	}

}
