package com.agc.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany( fetch=FetchType.EAGER,
				mappedBy="producer",
				cascade = {CascadeType.PERSIST, CascadeType.DETACH, 
						   CascadeType.MERGE, CascadeType.REFRESH})
	private List<ProducerCode> producerCodes;

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

	public List<ProducerCode> getProducerCodes() {
		return producerCodes;
	}

	public void setProducerCodes(List<ProducerCode> producerCodes) {
		this.producerCodes = producerCodes;
	}
	
	public void addProducerCode(ProducerCode producerCode) {
		if(this.producerCodes == null) {
			this.producerCodes = new ArrayList<>();
		}
		this.producerCodes.add(producerCode);
		producerCode.setProducer(this);
	}

	
}
