package org.backy.security;

import org.backy.domain.CustomUser;
import org.backy.domain.MemberVO;
import org.backy.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.extern.log4j.Log4j;


@Log4j
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private MemberMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.warn("Load user by username > " + username);
		
		MemberVO vo = mapper.read(username);
		
		log.warn("queried by member mapper > " + vo);
		return vo == null? null : new CustomUser(vo);
	}

}
