package org.backy.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;

//로그인 성공시 실행되는 part
@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
	
		log.info("Login Success");
		List<String> roleNames = new ArrayList<String>();
		
		auth.getAuthorities().forEach(auth2 -> roleNames.add(auth2.getAuthority()));
		
		log.warn("-----------------------");
		log.warn(auth.getName());
		log.warn(auth.getPrincipal().toString());
		log.warn("-----------------------");
		log.warn("Role names : " + roleNames);
		
		if(roleNames.contains("ROLE_ADMIN")) {
			log.info("들어옴");
			response.sendRedirect("/sample/admin");
			return;
		}
		if(roleNames.contains("ROLE_MEMBER")) {
			response.sendRedirect("/sample/member");
			return;
		}
		
		response.sendRedirect("/");
	}
	
}
