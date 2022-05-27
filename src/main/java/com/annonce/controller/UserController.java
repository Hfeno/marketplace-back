package com.annonce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.annonce.entities.Annonce;
import com.annonce.entities.Role;
import com.annonce.entities.Usermanager;
import com.annonce.service.AnnonceService;
import com.annonce.service.RoleService;
import com.annonce.service.UserService;

@RestController
@CrossOrigin
@RequestMapping(path="/gestion")
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;
	@Autowired
	AnnonceService annonceService;
	
	@RequestMapping(value="/adduser",method = RequestMethod.POST)
	public @ResponseBody Usermanager addNewUser(@RequestBody Usermanager user) {
		Role role = roleService.getRolebyName("ROLE_USER");
		List<Role>roles=new ArrayList<>();
		roles.add(role);
		String psw = user.getPassword();
		String pswC = BCrypt.hashpw(psw, BCrypt.gensalt(10));
		user.setPassword(pswC);
		user.setRole(roles);
	    userService.save(user);
		return user;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/getallusers",method = RequestMethod.GET)
	public @ResponseBody List<Usermanager>getalluser(){
		return userService.findAll();
	}
	
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/getuserbylog/{log}", method = RequestMethod.GET)
	public Usermanager findOneUserByLog(@PathVariable("log") String login) {
		return userService.findByusername(login);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
		@RequestMapping(value = "/getuserbyid/{id}", method = RequestMethod.GET)
		public Usermanager findOneUserById(@PathVariable("id") Long id) {
			return userService.findUserById(id);
		}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/deleteuserbyid/{id}", method = RequestMethod.DELETE)
	public void deleteOneUser(@PathVariable("id") Long id) {
		Usermanager user = userService.findUserById(id);
		List<Annonce> annonces =user.getAnnonces();
		for(Annonce annonce:annonces) {annonceService.deleteAnnoncebyId(annonce.getId());}	
		userService.delete(user);
	}

}
