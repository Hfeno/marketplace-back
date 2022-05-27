package com.annonce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.annonce.entities.Annonce;
import com.annonce.service.AnnonceService;
import com.annonce.service.CategorieService;
import com.annonce.service.RegionService;


@RestController
@CrossOrigin
@RequestMapping(path="/annonce")
public class AnnonceController {

	@Autowired
    AnnonceService annonceService;
	@Autowired
	CategorieService categorieService;
	@Autowired
	RegionService regionService;
	
	//@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")    
	@RequestMapping(value = "/addannonce", method = RequestMethod.POST)
    public  Annonce addAnnonce( @RequestBody Annonce annonce ) {
            annonceService.createAnnonce(annonce);
			return annonce;
    }
	
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/getallannonces", method=RequestMethod.GET)
	public List<Annonce> getallannonces(){
		List<Annonce> annonces = annonceService.getAllListAnnonce();
		return annonces;}
	
	//@PreAuthorize("hasRole('ROLE_ADMIN')")	
	@RequestMapping(value = "/getannoncebyid/{id}",method = RequestMethod.GET)
	public Annonce getannoncebyid(@PathVariable("id") Long id) {
		return annonceService.getAnnonceById(id);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/getannoncesbytitle/{title}", method=RequestMethod.GET)
	public List<Annonce> getannoncesbytitle(@PathVariable("title") String title){
		return annonceService.getAnnoncesbyTitle(title);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/getannoncesbycom/{com}", method=RequestMethod.GET)
	public List<Annonce> getannoncesbycom(@PathVariable("com") String texte){
		return annonceService.getAnnoncesbyTitle(texte);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/getannoncesbymaxprice/{price}", method=RequestMethod.GET)
	public List<Annonce> getannoncesbymaxprice(@PathVariable("price") Double price){
		return annonceService.getAnnoncesbyMaxPrice(price);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/getannoncesbyminprice/{price}", method=RequestMethod.GET)
	public List<Annonce> getannoncesbyminprice(@PathVariable("price") Double price){
		return annonceService.getAnnoncesbyMinPrice(price);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/getannoncesbydate/{date}", method=RequestMethod.GET)
	public List<Annonce> getannoncesbyDate(@PathVariable("cp") String date){
		return annonceService.getAnnoncesbyDate(date);
	}
	
	
//	@PreAuthorize("hasRole('ROLE_ADMIN')")	
//	@RequestMapping(value = "/getannoncesbyidcat/{id}",method = RequestMethod.GET)
//	public List<Annonce> getannoncesbyidcat(@PathVariable("id") Long id) {
//		return categorieService.getCategorieById(id).getAnnonces();
//	}
	
	//@PreAuthorize("hasRole('ROLE_ADMIN')")	
	@RequestMapping(value = "/getannoncesbynomcat/{nom}",method = RequestMethod.GET)
	public List<Annonce> getannoncesbynomcat(@PathVariable("nom") String nom) {
		return categorieService.getCategorieByName(nom).getAnnonces();
	}
	
//	@PreAuthorize("hasRole('ROLE_ADMIN')")	
//	@RequestMapping(value = "/getannoncesbyidreg/{id}",method = RequestMethod.GET)
//	public List<Annonce> getannoncesbyidreg(@PathVariable("id") Long id) {
//		return regionService.getRegionById(id).getAnnonces();
//	}
	
	//@PreAuthorize("hasRole('ROLE_ADMIN')")	
	@RequestMapping(value = "/getannoncesbynomreg/{nom}",method = RequestMethod.GET)
	public List<Annonce> getannoncesbynomreg(@PathVariable("nom") String nom) {
		return regionService.getRegionByName(nom).getAnnonces();
	}
	
	//@PreAuthorize("hasRole('ROLE_ADMIN')")	
	@RequestMapping(value = "/getannoncesbynomcatreg/{nom1}/{nom2}",method = RequestMethod.GET)
	public List<Annonce> getannoncesbynomcatreg(@PathVariable("nom1") String nom1, @PathVariable("nom2") String nom2) {
		List<Annonce> annoncesCat = categorieService.getCategorieByName(nom1).getAnnonces();
		List<Annonce> annoncesCatReg = new ArrayList<>();
		for (Annonce annonceCat:annoncesCat) {
			if(annonceCat.getRegion().getNom()==regionService.getRegionByName(nom2).getNom()) {		
				annoncesCatReg.add(annonceCat);	}			};
		return annoncesCatReg;
	}
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/deleteannoncebyid/{id}", method = RequestMethod.DELETE)
	public void deleteannoncebyid(@PathVariable("id") Long id) {
		annonceService.deleteAnnoncebyId(id);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/deleteannonces", method = RequestMethod.DELETE)
	public void deleteannonces() {
		annonceService.deleteAllAnnonces();;
		}
	
}
