package com.annonce.entities;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Annonce")
public class Annonce {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name = "titre")
    private String titre;
    
    @Column(name = "texte")
    private String texte;
    @Column(name = "prix")
    private double prix;
    @Column(name = "photo")
    private String photo;
    @Column(name = "date")
    private Date date;
        
    @Column(name = "spec1")
    private String spec1;
    @Column(name = "spec2")
    private String spec2;
    @Column(name = "spec3")
    private String spec3;
        
    @ManyToOne //(optional=false)
	@JoinColumn(name = "categorie")
	private Categorie categorie;
    
    @ManyToOne //(optional=false)
	@JoinColumn(name = "region")
	private Region region;
    
    @ManyToOne //(optional=false)
	@JoinColumn(name = "usermanager")
	private Usermanager usermanager;

		public Annonce() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Annonce(String titre, String texte, double prix, String photo, Date date, String spec1,
				String spec2, String spec3, Categorie categorie, Region region, Usermanager usermanager) {
			super();
			this.titre = titre;
			this.texte = texte;
			this.prix = prix;
			this.photo = photo;
			this.date = date;
			this.spec1 = spec1;
			this.spec2 = spec2;
			this.spec3 = spec3;
			this.categorie = categorie;
			this.region = region;
			this.usermanager = usermanager;
		}

	

	public Annonce(long id, String titre, String texte, double prix, String photo, Date date, 
			String spec1, String spec2, String spec3, Categorie categorie, Region region, Usermanager usermanager) {
		super();
		this.id = id;
		this.titre = titre;
		this.texte = texte;
		this.prix = prix;
		this.photo = photo;
		this.date = date;
		this.spec1 = spec1;
		this.spec2 = spec2;
		this.spec3 = spec3;
		this.categorie = categorie;
		this.region = region;
		this.usermanager = usermanager;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSpec1() {
		return spec1;
	}

	public void setSpec1(String spec1) {
		this.spec1 = spec1;
	}

	public String getSpec2() {
		return spec2;
	}

	public void setSpec2(String spec2) {
		this.spec2 = spec2;
	}

	public String getSpec3() {
		return spec3;
	}

	public void setSpec3(String spec3) {
		this.spec3 = spec3;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}	

	public Usermanager getUsermanager() {
		return usermanager;
	}

	public void setUsermanager(Usermanager usermanager) {
		this.usermanager = usermanager;
	}



	@Override
	public String toString() {
		return "Annonce [id=" + id + ", titre=" + titre + ", texte=" + texte + ", prix=" + prix + ", photo=" + photo
				+ ", date=" + date + ", spec1=" + spec1 + ", spec2=" + spec2
				+ ", spec3=" + spec3 + "]";
	}

	
    
	
    
}
