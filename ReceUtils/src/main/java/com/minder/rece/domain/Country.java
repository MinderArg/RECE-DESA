package com.minder.rece.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class Country implements Serializable{

	private static final long serialVersionUID = -6519227203562007425L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;

	@Column(name="unique_employee_key_label")
	private String uniqueEmployeeKeyLabel;

	@Column(name="unique_employee_key_pattern")
	private String uniqueEmployeeKeyPattern;

	@Column(name="unique_company_key_label")
	private String uniqueCompanyKeyLabel;

	@Column(name="unique_company_key_pattern")
	private String uniqueCompanyKeyPattern;

	@ManyToOne
	@JoinColumn(name = "language_id")
	private Language language;
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auditData == null) ? 0 : auditData.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((uniqueCompanyKeyLabel == null) ? 0 : uniqueCompanyKeyLabel.hashCode());
		result = prime * result
				+ ((uniqueCompanyKeyPattern == null) ? 0 : uniqueCompanyKeyPattern.hashCode());
		result = prime * result + ((uniqueEmployeeKeyLabel == null) ? 0 : uniqueEmployeeKeyLabel.hashCode());
		result = prime * result
				+ ((uniqueEmployeeKeyPattern == null) ? 0 : uniqueEmployeeKeyPattern.hashCode());
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
		Country other = (Country) obj;
		if (auditData == null) {
			if (other.auditData != null)
				return false;
		} else if (!auditData.equals(other.auditData))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (uniqueCompanyKeyLabel == null) {
			if (other.uniqueCompanyKeyLabel != null)
				return false;
		} else if (!uniqueCompanyKeyLabel.equals(other.uniqueCompanyKeyLabel))
			return false;
		if (uniqueCompanyKeyPattern == null) {
			if (other.uniqueCompanyKeyPattern != null)
				return false;
		} else if (!uniqueCompanyKeyPattern.equals(other.uniqueCompanyKeyPattern))
			return false;
		if (uniqueEmployeeKeyLabel == null) {
			if (other.uniqueEmployeeKeyLabel != null)
				return false;
		} else if (!uniqueEmployeeKeyLabel.equals(other.uniqueEmployeeKeyLabel))
			return false;
		if (uniqueEmployeeKeyPattern == null) {
			if (other.uniqueEmployeeKeyPattern != null)
				return false;
		} else if (!uniqueEmployeeKeyPattern.equals(other.uniqueEmployeeKeyPattern))
			return false;
		return true;
	}

}
