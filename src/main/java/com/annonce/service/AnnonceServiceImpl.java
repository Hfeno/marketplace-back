package com.annonce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annonce.entities.Annonce;
import com.annonce.repository.AnnonceRepository;

@Service
public class AnnonceServiceImpl implements AnnonceService{

	@Autowired
	private AnnonceRepository annonceRepository;
	
	@Override
	public void createAnnonce(Annonce annonce) {
	annonceRepository.save(annonce);		
	}

	@Override
	public void deleteAnnoncebyId(Long id) {
	annonceRepository.deleteById(id);		
	}

	@Override
	public void deleteAllAnnonces() {
	annonceRepository.deleteAll();		
	}

	@Override
	public void updateAnnonce(Annonce annonce) {
	annonceRepository.save(annonce);
		
	}

	@Override
	public List<Annonce> getAllListAnnonce() {
		return annonceRepository.findAll();
	}

	@Override
	public Annonce getAnnonceById(Long id) {
		return annonceRepository.findAnnonceById(id);
	}
	
	@Override
	public List<Annonce> getAnnoncesbyTitle(String title) {
		return annonceRepository.findbyTitle(title);
	}

	@Override
	public List<Annonce> getAnnoncebyCom(String comment) {
		return annonceRepository.findbyCom(comment);
	}

	@Override
	public List<Annonce> getAnnoncesbyMaxPrice(Double price) {
		return annonceRepository.findbyMaxPrice(price);
	}
	
	@Override
	public List<Annonce> getAnnoncesbyMinPrice(Double price) {
		return annonceRepository.findbyMinPrice(price);
	}

	@Override
	public List<Annonce> getAnnoncesbyDate(String date) {
		return annonceRepository.findbyDate(date);
	}

		

	
}
