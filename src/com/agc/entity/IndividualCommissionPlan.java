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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "individual_commission_plan")
public class IndividualCommissionPlan {
	
	@Id
	@Column(name = "Id", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne( cascade = CascadeType.ALL )
	@JoinColumn( name = "producer_code_id" )
	private ProducerCode producerCode;

	@OneToMany(	fetch = FetchType.LAZY, 
				mappedBy = "individualCommissionPlan", 
				cascade = CascadeType.ALL)
	private List<ChargePatternCommissionRate> chargePatternCommissionRates;

	public ProducerCode getProducerCode() {
		return producerCode;
	}

	public void setProducerCode(ProducerCode producerCode) {
		this.producerCode = producerCode;
	}

	public List<ChargePatternCommissionRate> getChargePatternCommissionRates() {
		return chargePatternCommissionRates;
	}

	public void setChargePatternCommissionRates(List<ChargePatternCommissionRate> chargePatternCommissionRates) {
		this.chargePatternCommissionRates = chargePatternCommissionRates;
	}

	public void addChargePatternCommissionRate(ChargePatternCommissionRate chargePatternCommissionRate) {
		chargePatternCommissionRate.setIndividualCommissionPlan(this);;
		if(this.chargePatternCommissionRates == null) {
			this.chargePatternCommissionRates = new ArrayList<>();
		}
		this.chargePatternCommissionRates.add(chargePatternCommissionRate);	
	}
}
