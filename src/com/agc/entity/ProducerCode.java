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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.agc.entity.iface.IHavingPublicID;

@Entity
@Table(name = "producer_code")
public class ProducerCode implements IHavingPublicID {
	@Id
	@Column(name = "Id", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "publicid", length = 55, nullable = false, unique=true)
	private String publicID;

	@Column(name = "code", length = 55, nullable = false)
	private String code;

	@ManyToOne(	cascade = { CascadeType.PERSIST, CascadeType.DETACH, 
							CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "producer_id")
	private Producer producer;

	@ManyToOne(	cascade = { CascadeType.PERSIST, CascadeType.DETACH, 
							CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "parent_producer_code_id")
	private ProducerCode parentProducerCode;

	@OneToMany(	fetch = FetchType.EAGER, 
				mappedBy = "parentProducerCode", 
				cascade = { CascadeType.PERSIST, CascadeType.DETACH,
							CascadeType.MERGE, CascadeType.REFRESH })
	private List<ProducerCode> childrenProducerCodes;

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

	public ProducerCode getParentProducerCode() {
		return parentProducerCode;
	}

	public void setParentProducerCode(ProducerCode parentProducerCode) {
		this.parentProducerCode = parentProducerCode;
	}

	public List<ProducerCode> getChildrenProducerCodes() {
		return childrenProducerCodes;
	}

	public void setChildrenProducerCodes(List<ProducerCode> childrenProducerCodes) {
		this.childrenProducerCodes = childrenProducerCodes;
	}
	
	public void addChildProducerCode(ProducerCode childProducerCode) {
		childProducerCode.setParentProducerCode(this);
		if(this.childrenProducerCodes == null) {
			this.childrenProducerCodes = new ArrayList<>();
		}
		this.childrenProducerCodes.add(childProducerCode);	
	}

	@Override
	public String toString() {
		return "ProducerCode [publicID=" + publicID + ", code=" + code + "]";
	}
	
}
