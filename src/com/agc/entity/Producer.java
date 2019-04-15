package com.agc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producer")
public class Producer {
	
	@Id
	@Column(name="Id", unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="publicid", length=55, nullable=false)
	private String publicID;
	
	@Column(name="name", length=55, nullable=false)
	private String name;
	
	@Column(name="email", length=55, nullable=false)
	private String email;

	public Producer(String publicID, String name, String email) {
		this.publicID = publicID;
		this.name = name;
		this.email = email;
	}
	
	public Producer() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public String getPublicID() {
		return publicID;
	}

	public void setPublicID(String publicID) {
		this.publicID = publicID;
	}

	
}
