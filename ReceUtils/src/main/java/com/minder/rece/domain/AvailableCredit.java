package com.minder.rece.domain;
import javax.persistence.*;

@Entity
@Table(name = "available_credits")
public class AvailableCredit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private int amount;

	@Column(name="remaining_amount")
	private int remainingAmount;

	@ManyToOne
	@JoinColumn(name = "credit_id")
	private Credit credit;

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

	public Credit getCredit() {
		return credit;
	}

	public void setCredit(Credit credit) {
		this.credit = credit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((credit == null) ? 0 : credit.hashCode());
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
		AvailableCredit other = (AvailableCredit) obj;
		if (amount != other.amount)
			return false;
		if (credit == null) {
			if (other.credit != null)
				return false;
		} else if (!credit.equals(other.credit))
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
