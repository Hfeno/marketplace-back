package com.annonce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annonce.entities.Usermanager;
import com.annonce.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public Usermanager findBylogin(String login, String password) {
		return userRepository.authentificate(login, password);
	}

	@Override
	public Usermanager findByusername(String login) {
		return userRepository.findbyname(login);
	}

	@Override
	public Usermanager save(Usermanager user) {
		return userRepository.save(user);
	}

	@Override
	public List<Usermanager> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void delete(Usermanager user) {
		userRepository.delete(user);
	}

	@Override
	public Usermanager findUserById(Long id) {
		return userRepository.findUsermanagerById(id);
	}
	
	
}
