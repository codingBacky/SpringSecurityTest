package org.backy.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j;
//잘 안씀
@Log4j
public class CustomNoOpPasswordEncoder implements PasswordEncoder{
	@Override
	public String encode(CharSequence rawPassword) {
		return rawPassword.toString();
	}
	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return rawPassword.toString().equals(encodedPassword);
	}
}
