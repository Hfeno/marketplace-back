package com.annonce.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
public class Usermanager implements Serializable{
	
	@Id
	@GeneratedValue
	private long code_user;
	private String login;
	private String password;
	private String name_user;
	private String email;
	private String tel;
	
	@JsonIgnore
	@OneToMany(mappedBy = "usermanager")
	private List<Annonce> annonces;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_role", joinColumns= @JoinColumn(name="user_id",referencedColumnName="code_user")
	,inverseJoinColumns=@JoinColumn(name="role_id",referencedColumnName="id_role"))
	private List<Role> role;

	public Usermanager() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Usermanager(long code_user, String login, String password, String name_user, String email, String tel,
			List<Annonce> annonces, List<Role> role) {
		super();
		this.code_user = code_user;
		this.login = login;
		this.password = password;
		this.name_user = name_user;
		this.email = email;
		this.tel = tel;
		this.annonces = annonces;
		this.role = role;
	}



	public long getCode_user() {
		return code_user;
	}

	public void setCode_user(long code_user) {
		this.code_user = code_user;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	//@JsonIgnore //le password n'est pas présent dans le format json//le password ne sort pas du back end
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName_user() {
		return name_user;
	}

	public void setName_user(String name_user) {
		this.name_user = name_user;
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public List<Annonce> getAnnonces() {
		return annonces;
	}


	public void setAnnonces(List<Annonce> annonces) {
		this.annonces = annonces;
	}
	
	

}
