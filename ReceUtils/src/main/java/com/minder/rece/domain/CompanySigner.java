package com.minder.rece.domain;

import javax.persistence.*;

@Entity
@Table(name = "company_signers")
public class CompanySigner extends Signer {

	@Column(name="uri_signature")
	private String uriSignature;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	public String getUriSignature() {
		return uriSignature;
	}

	public void setUriSignature(String uriSignature) {
		this.uriSignature = uriSignature;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((uriSignature == null) ? 0 : uriSignature.hashCode());
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
		CompanySigner other = (CompanySigner) obj;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (uriSignature == null) {
			if (other.uriSignature != null)
				return false;
		} else if (!uriSignature.equals(other.uriSignature))
			return false;
		return true;
	}

}
