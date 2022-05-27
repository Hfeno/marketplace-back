package com.annonce.service;

import java.util.List;

import com.annonce.entities.Region;

public interface RegionService {

	void addRegion(Region region);
	void deleteRegionbyId(Long id);
	public void deleteAllRegion();
	void updateRegion(Region region);
	List<Region> getAllListRegion();
	Region getRegionById(Long id);
	Region getRegionByName(String nom);
}
