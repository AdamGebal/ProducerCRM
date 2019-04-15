package com.agc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	public ProducerCode(String publicID, String code) {
		this.publicID = publicID;
		this.code = code;
	}
}
