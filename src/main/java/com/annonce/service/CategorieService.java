package com.annonce.service;

import java.util.List;

import com.annonce.entities.Categorie;

public interface CategorieService {

	void createCategorie(Categorie categorie);
	void deleteCategoriebyId(Long id);
	public void deleteAllCategories();
	void updateCategorie(Categorie categorie);
	List<Categorie> getAllListCategorie();
	Categorie getCategorieById(Long id);
	Categorie getCategorieByName(String nom);
}
