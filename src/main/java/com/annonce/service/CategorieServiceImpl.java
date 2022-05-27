package com.annonce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annonce.entities.Categorie;
import com.annonce.repository.CategorieRepository;

@Service
public class CategorieServiceImpl implements CategorieService {

	@Autowired
	CategorieRepository categorieRepository;
	
	@Override
	public void createCategorie(Categorie categorie) {
		categorieRepository.save(categorie);
		
	}

	@Override
	public void deleteCategoriebyId(Long id) {
		Categorie cat = categorieRepository.findCategorieById(id);
		categorieRepository.delete(cat);
	}

	@Override
	public void deleteAllCategories() {
		categorieRepository.deleteAll();
	}

	@Override
	public void updateCategorie(Categorie categorie) {
		categorieRepository.save(categorie);
	}

	@Override
	public List<Categorie> getAllListCategorie() {
		return categorieRepository.findAll();
	}

	@Override
	public Categorie getCategorieById(Long id) {
		return categorieRepository.findCategorieById(id);
	}

	@Override
	public Categorie getCategorieByName(String nom) {
		return categorieRepository.findCategorieByNom(nom);
	}
	
}
