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
	
	@Embedded
	private AuditData auditData;
	
	public AuditData getAuditData() {
		return auditData;
	}

	public void setAuditData(AuditData auditData) {
		this.auditData = auditData;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((auditData == null) ? 0 : auditData.hashCode());
		result = prime * result + ((businessPlan == null) ? 0 : businessPlan.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + remainingAmount;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Credit other = (Credit) obj;
		if (amount != other.amount)
			return false;
		if (auditData == null) {
			if (other.auditData != null)
				return false;
		} else if (!auditData.equals(other.auditData))
			return false;
		if (businessPlan == null) {
			if (other.businessPlan != null)
				return false;
		} else if (!businessPlan.equals(other.businessPlan))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (remainingAmount != other.remainingAmount)
			return false;
		return true;
	}

}
