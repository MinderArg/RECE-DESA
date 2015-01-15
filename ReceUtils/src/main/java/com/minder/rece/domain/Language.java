package com.minder.rece.domain;

import javax.persistence.*;

@Entity
@Table(name = "languages")
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;

	private String description;

	private String uriAppLabels;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUriAppLabels() {
		return uriAppLabels;
	}

	public void setUriAppLabels(String uriAppLabels) {
		this.uriAppLabels = uriAppLabels;
	}

}
