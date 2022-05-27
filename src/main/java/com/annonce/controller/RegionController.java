package com.annonce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.annonce.entities.Region;
import com.annonce.service.RegionService;

@RestController
@CrossOrigin
@RequestMapping(path="/region")
public class RegionController {

	@Autowired
	RegionService regionService;
		
	@PreAuthorize("hasRole('ROLE_ADMIN')")	
	@RequestMapping(value = "/getregionbyid/{id}",method = RequestMethod.GET)
	public Region getcategoriebyid(@PathVariable("id") Long id) {
		return regionService.getRegionById(id);
	}
	
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
		@RequestMapping(value = "/getallregions",method = RequestMethod.GET)
		public List<Region> getallcategories() {
			return regionService.getAllListRegion();
		}
}
