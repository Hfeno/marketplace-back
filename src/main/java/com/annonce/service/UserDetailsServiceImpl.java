package com.annonce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.annonce.entities.Usermanager;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usermanager usermanager=userService.findByusername(username);
		if (usermanager==null) throw new UsernameNotFoundException(username);
		
		List<GrantedAuthority>authorities=new ArrayList<>();
		usermanager.getRole().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getRole_name()));
		});
		
		return (UserDetails) new User(usermanager.getLogin(),usermanager.getPassword(),authorities);
	}
}

