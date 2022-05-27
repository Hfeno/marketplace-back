package com.annonce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annonce.entities.Region;
import com.annonce.repository.RegionRepository;

@Service
public class RegionServiceImpl implements RegionService{

	@Autowired
	RegionRepository regionRepository;

	@Override
	public void addRegion(Region region) {
		regionRepository.save(region)	;	
	}

	@Override
	public void deleteRegionbyId(Long id) {
		Region reg = regionRepository.findRegionById(id);
		regionRepository.delete(reg);		
	}

	@Override
	public void deleteAllRegion() {
		regionRepository.deleteAll();
	}

	@Override
	public void updateRegion(Region region) {
		regionRepository.save(region)	;		
	}

	@Override
	public List<Region> getAllListRegion() {
		return regionRepository.findAll();
	}

	@Override
	public Region getRegionById(Long id) {
		return regionRepository.findRegionById(id);
	}

	@Override
	public Region getRegionByName(String nom) {
		return regionRepository.findRegionByNom(nom);
	}
	
	
}
