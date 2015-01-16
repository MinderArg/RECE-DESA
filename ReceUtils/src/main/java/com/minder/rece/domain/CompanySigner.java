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

}
