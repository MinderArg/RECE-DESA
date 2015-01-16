package com.minder.rece.domain;

import javax.persistence.*;

@Entity
@Table(name = "credits")
public class Credit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private int amount;

	@Column(name="remaining_amount")
	private int remainingAmount;

	@ManyToOne
	@JoinColumn(name = "business_plan_id")
	private BusinessPlan businessPlan;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getRemainingAmount() {
		return remainingAmount;
	}

	public void setRemainingAmount(int remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	public BusinessPlan getBusinessPlan() {
		return businessPlan;
	}

	public void setBusinessPlan(BusinessPlan businessPlan) {
		this.businessPlan = businessPlan;
	}

}
