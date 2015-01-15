package com.minder.rece.domain;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	private String uniqueEmployeeKeyLabel;
	
	private String uniqueEmployeeKeyPattern;
	
	private String uniqueCompanyKeyLabel;
	
	private String uniqueCompanyKeyPattern;

	@ManyToOne
	@JoinColumn(name = "language_id")
	private Language language;

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

	public String getUniqueEmployeeKeyLabel() {
		return uniqueEmployeeKeyLabel;
	}

	public void setUniqueEmployeeKeyLabel(String uniqueEmployeeKeyLabel) {
		this.uniqueEmployeeKeyLabel = uniqueEmployeeKeyLabel;
	}

	public String getUniqueEmployeeKeyPattern() {
		return uniqueEmployeeKeyPattern;
	}

	public void setUniqueEmployeeKeyPattern(String uniqueEmployeeKeyPattern) {
		this.uniqueEmployeeKeyPattern = uniqueEmployeeKeyPattern;
	}

	public String getUniqueCompanyKeyLabel() {
		return uniqueCompanyKeyLabel;
	}

	public void setUniqueCompanyKeyLabel(String uniqueCompanyKeyLabel) {
		this.uniqueCompanyKeyLabel = uniqueCompanyKeyLabel;
	}

	public String getUniqueCompanyKeyPattern() {
		return uniqueCompanyKeyPattern;
	}

	public void setUniqueCompanyKeyPattern(String uniqueCompanyKeyPattern) {
		this.uniqueCompanyKeyPattern = uniqueCompanyKeyPattern;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}
