package com.annonce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annonce.entities.Role;
import com.annonce.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Role getRolebyName(String role) {		
		return roleRepository.findRoleByName(role);
	}

}
