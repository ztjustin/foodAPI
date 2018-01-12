package com.foodAPI.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.foodAPI.entity.Role;
import com.foodAPI.service.UserService;


@Service("authService")
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userServiceImpl;
	
	private static final Log LOG = LogFactory.getLog(JwtUserDetailsServiceImpl.class);
	
	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		com.foodAPI.entity.User user = userServiceImpl.getOne(username);
		if(user!=null)
		{
			Set<Role> roles = new HashSet<Role>();
			roles.add(user.getRole());
			List<GrantedAuthority> authorities = buildAuthorities(roles);
			return buildUser(user, authorities);
		}
		else return  null;
		
		
	}

	private User buildUser(com.foodAPI.entity.User user, List<GrantedAuthority> authorities) {
		return new User(user.getUserName(), user.getPassword(),user.isEnable(),true,true,true, authorities);
	}

	private List<GrantedAuthority> buildAuthorities(Set<Role> roles) {
		
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();

		for (Role rol : roles) {
			LOG.info("EL ROLE ES:"+rol.getName());
			auths.add(new SimpleGrantedAuthority(rol.getName().toUpperCase()));
		}
		
		LOG.info("EL GrantedAuthority ES:"+auths.toString());

		return new ArrayList<GrantedAuthority>(auths);
	}
}


