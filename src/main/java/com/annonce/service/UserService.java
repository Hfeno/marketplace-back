package com.annonce.service;

import java.util.List;

import com.annonce.entities.Usermanager;

public interface UserService {

	public Usermanager findBylogin(String login, String password);
	public Usermanager findByusername(String login);
	
	
	public Usermanager save(Usermanager user);
	public Usermanager findUserById(Long id);
	public List<Usermanager> findAll();
	public void delete(Usermanager user);
	
}
