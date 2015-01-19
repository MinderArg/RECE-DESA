package com.minder.rece.domain;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "holdings")
public class Holding {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String name;

	private String address;

	@Column(name="unique_holding_key")
	private String uniqueHoldingKey;
	
	private boolean sharingCredit;

	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;

	public boolean isSharingCredit() {
		return sharingCredit;
	}

	public void setSharingCredit(boolean sharingCredit) {
		this.sharingCredit = sharingCredit;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "holding_id")
	private Set<Credit> credits;

	@OneToMany(mappedBy = "holding", cascade = CascadeType.ALL)
	private Set<Company> companies;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUniqueHoldingKey() {
		return uniqueHoldingKey;
	}

	public void setUniqueHoldingKey(String uniqueHoldingKey) {
		this.uniqueHoldingKey = uniqueHoldingKey;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Set<Credit> getCredits() {
		return credits;
	}

	public void setCredits(Set<Credit> credits) {
		this.credits = credits;
	}

	public Set<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((auditData == null) ? 0 : auditData.hashCode());
		result = prime * result + ((companies == null) ? 0 : companies.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((credits == null) ? 0 : credits.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (sharingCredit ? 1231 : 1237);
		result = prime * result + ((uniqueHoldingKey == null) ? 0 : uniqueHoldingKey.hashCode());
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
		Holding other = (Holding) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (auditData == null) {
			if (other.auditData != null)
				return false;
		} else if (!auditData.equals(other.auditData))
			return false;
		if (companies == null) {
			if (other.companies != null)
				return false;
		} else if (!companies.equals(other.companies))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (credits == null) {
			if (other.credits != null)
				return false;
		} else if (!credits.equals(other.credits))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sharingCredit != other.sharingCredit)
			return false;
		if (uniqueHoldingKey == null) {
			if (other.uniqueHoldingKey != null)
				return false;
		} else if (!uniqueHoldingKey.equals(other.uniqueHoldingKey))
			return false;
		return true;
	}

}
