package com.annonce.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="role")
public class Role implements Serializable{

	@Id
	private long id_role;
	private String role_name;
//	@ManyToMany
//	@JsonBackReference
//	private List <Usermanger>  usermanagers; //pas nécessaire
	public Role() {
		
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(long id_role, String role_name) {
		super();
		this.id_role = id_role;
		this.role_name = role_name;
		
	}
	public long getId_role() {
		return id_role;
	}
	public void setId_role(long id_role) {
		this.id_role = id_role;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	
	
}
