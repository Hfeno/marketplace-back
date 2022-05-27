package com.annonce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.annonce.entities.Categorie;
import com.annonce.service.CategorieService;

@RestController
@CrossOrigin
@RequestMapping(path="/categorie")
public class CategorieController {
	
	@Autowired
	CategorieService categorieService;
		
	@PreAuthorize("hasRole('ROLE_ADMIN')")	
	@RequestMapping(value = "/getcategoriebyid/{id}",method = RequestMethod.GET)
	public Categorie getcategoriebyid(@PathVariable("id") Long id) {
		return categorieService.getCategorieById(id);
	}
	
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/getallcategories",method = RequestMethod.GET)
	public List<Categorie> getallcategories() {
		return categorieService.getAllListCategorie();
	}
	
}
