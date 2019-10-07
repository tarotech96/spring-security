/**
 * 
 */
package com.example.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * @author nguye
 *
 */

@Component
public class MyAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authenticationException) throws IOException, ServletException {
		response.addHeader("WWWW-Authenticate", "Basic realm=" + getRealmName());
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// realmName display on window login
		setRealmName("taro_oppa");
		super.afterPropertiesSet();
	}

}
