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

	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "holding_id")
	private Set<Credit> credits;

	@OneToMany(mappedBy = "holding", cascade = CascadeType.ALL)
	private Set<Company> companies;

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

}
