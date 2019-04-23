package com.agc.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(	name = "charge_pattern_commission_rate",
		uniqueConstraints = @UniqueConstraint( columnNames = {
								"individual_commission_plan_id", 
								"charge_pattern"}))
				
		
public class ChargePatternCommissionRate {
	
	@Id
	@Column(name = "Id", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne( cascade = CascadeType.ALL )
	@JoinColumn( name = "individual_commission_plan_id" )
	private IndividualCommissionPlan individualCommissionPlan;
	
	@Column(name = "charge_pattern", length = 55, nullable = false)
	private String chargePattern;
	
	@Column(name="commission_rate", precision = 5, scale = 2, nullable = false)
	private BigDecimal commissionRate;

	public IndividualCommissionPlan getIndividualCommissionPlan() {
		return individualCommissionPlan;
	}

	public void setIndividualCommissionPlan(IndividualCommissionPlan individualCommissionPlan) {
		this.individualCommissionPlan = individualCommissionPlan;
	}

	public String getChargePattern() {
		return chargePattern;
	}

	public void setChargePattern(String chargePattern) {
		this.chargePattern = chargePattern;
	}

	public BigDecimal getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(BigDecimal commissionRate) {
		this.commissionRate = commissionRate;
	}
	
}
