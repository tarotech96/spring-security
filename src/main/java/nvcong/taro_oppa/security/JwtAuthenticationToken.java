/**
 * 
 */
package nvcong.taro_oppa.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * @author Taro
 *	The class will return a token
 */
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String token;
	public JwtAuthenticationToken(String token) {
		super(null, null);
		// TODO Auto-generated constructor stub
		this.token = token;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	@Override
	public Object getCredentials() {
		return null;
	}
	
	@Override
	public Object getPrincipal() {
		return null;
	}

}
