package com.annonce.service;

import java.util.List;

import com.annonce.entities.Annonce;

public interface AnnonceService {
	
	void createAnnonce(Annonce annonce);
	void deleteAnnoncebyId(Long id);
	public void deleteAllAnnonces();
	void updateAnnonce(Annonce annonce);
	List<Annonce> getAllListAnnonce();
	List<Annonce> getAnnoncesbyTitle(String title);
	List<Annonce> getAnnoncebyCom(String comment);
	List<Annonce> getAnnoncesbyMaxPrice(Double price);
	List<Annonce> getAnnoncesbyMinPrice(Double price);
	List<Annonce> getAnnoncesbyDate(String date);
	
	Annonce getAnnonceById(Long id);
}
