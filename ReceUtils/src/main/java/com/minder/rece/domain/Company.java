package com.minder.rece.domain;

import javax.persistence.*;

@Entity
@Table(name = "companies")
public class Company {

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

}
