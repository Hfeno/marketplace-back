package com.annonce.entities;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Categorie")
public class Categorie{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "nom")
	private String nom;

	@JsonIgnore
	@OneToMany(mappedBy = "categorie")
	private List<Annonce> annonces; 
	
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categorie(long id, String nom, List<Annonce> annonces) {
		super();
		this.id = id;
		this.nom = nom;
		this.annonces = annonces;
	}

	public Categorie(String nom, List<Annonce> annonces) {
		super();
		this.nom = nom;
		this.annonces = annonces;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Annonce> getAnnonces() {
		return annonces;
	}

	public void setAnnonces(List<Annonce> annonces) {
	this.annonces = annonces;
	}	

	

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nom=" + nom + "]";
	}

	
}
