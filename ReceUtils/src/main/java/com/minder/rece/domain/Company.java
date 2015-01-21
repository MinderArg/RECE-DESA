package com.minder.rece.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "companies")
public class Company implements Serializable{

	private static final long serialVersionUID = 7176893578510300796L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	private String address;

	@Column(name="unique_company_key")
	private String uniqueCompanyKey;

	@Column(name="uri_logo")
	private String uriLogo;
	
	@ManyToOne
	@JoinColumn(name = "holding_id")
	private Holding holding;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "company_id")
	private Set<AvailableCredit> availableCredits;
	
	@Embedded
	private AuditData auditData;
	
	public AuditData getAuditData() {
		return auditData;
	}

	public void setAuditData(AuditData auditData) {
		this.auditData = auditData;
	}

	public Set<AvailableCredit> getAvailableCredits() {
		return availableCredits;
	}

	public void setAvailableCredits(Set<AvailableCredit> availableCredits) {
		this.availableCredits = availableCredits;
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

	public String getUniqueCompanyKey() {
		return uniqueCompanyKey;
	}

	public void setUniqueCompanyKey(String uniqueCompanyKey) {
		this.uniqueCompanyKey = uniqueCompanyKey;
	}

	public String getUriLogo() {
		return uriLogo;
	}

	public void setUriLogo(String uriLogo) {
		this.uriLogo = uriLogo;
	}

	public Holding getHolding() {
		return holding;
	}

	public void setHolding(Holding holding) {
		this.holding = holding;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((auditData == null) ? 0 : auditData.hashCode());
		result = prime * result + ((availableCredits == null) ? 0 : availableCredits.hashCode());
		result = prime * result + ((holding == null) ? 0 : holding.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((uniqueCompanyKey == null) ? 0 : uniqueCompanyKey.hashCode());
		result = prime * result + ((uriLogo == null) ? 0 : uriLogo.hashCode());
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
		Company other = (Company) obj;
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
		if (availableCredits == null) {
			if (other.availableCredits != null)
				return false;
		} else if (!availableCredits.equals(other.availableCredits))
			return false;
		if (holding == null) {
			if (other.holding != null)
				return false;
		} else if (!holding.equals(other.holding))
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
		if (uniqueCompanyKey == null) {
			if (other.uniqueCompanyKey != null)
				return false;
		} else if (!uniqueCompanyKey.equals(other.uniqueCompanyKey))
			return false;
		if (uriLogo == null) {
			if (other.uriLogo != null)
				return false;
		} else if (!uriLogo.equals(other.uriLogo))
			return false;
		return true;
	}

}
