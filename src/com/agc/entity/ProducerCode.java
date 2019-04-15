package com.agc.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "producer_code")
public class ProducerCode {
	@Id
	@Column(name="Id", unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="publicid", length=55, nullable=false)
	private String publicID;
	
	@Column(name="code", length=55, nullable=false)
	private String code;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, 
			   			  CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="producer_id")
	private Producer producer;


	public ProducerCode() {
	}
	
	public ProducerCode(String publicID, String code) {
		this.publicID = publicID;
		this.code = code;
	}

	public String getPublicID() {
		return publicID;
	}

	public void setPublicID(String publicID) {
		this.publicID = publicID;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}
}
