package com.minder.rece.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "file_split_and_sign_configurations")
public class FileSplitAndSignConfiguration implements Serializable{

	private static final long serialVersionUID = -4357902249235640843L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	private String description;
	
	private boolean hasDuplicate;
	
	private int pageWidth;
	
	private int pageHeight;

	private boolean landscaped;
	
	private boolean defaultConfiguration;
	
	private boolean hasLegend;
	
	private int employeeSignHeight;
	
	private int employeeSignWidth;
	
	private int employerSignHeight;
	
	private int employerSignWidth;
	
	private int employeeXPosition;
	
	private int employeeYPosition;
	
	private int employerXPosition;
	
	private String legendUrl;
	
	private int legendXPosition;
	
	private int legendYPosition;
	
	private boolean hasFirstOriginal;
	
	private boolean hasTwoPerPage;
	
	private int whereToCutXPosition;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isHasDuplicate() {
		return hasDuplicate;
	}

	public void setHasDuplicate(boolean hasDuplicate) {
		this.hasDuplicate = hasDuplicate;
	}

	public int getPageWidth() {
		return pageWidth;
	}

	public void setPageWidth(int pageWidth) {
		this.pageWidth = pageWidth;
	}

	public int getPageHeight() {
		return pageHeight;
	}

	public void setPageHeight(int pageHeight) {
		this.pageHeight = pageHeight;
	}

	public boolean isLandscaped() {
		return landscaped;
	}

	public void setLandscaped(boolean landscaped) {
		this.landscaped = landscaped;
	}

	public boolean isDefaultConfiguration() {
		return defaultConfiguration;
	}

	public void setDefaultConfiguration(boolean defaultConfiguration) {
		this.defaultConfiguration = defaultConfiguration;
	}

	public boolean isHasLegend() {
		return hasLegend;
	}

	public void setHasLegend(boolean hasLegend) {
		this.hasLegend = hasLegend;
	}

	public int getEmployeeSignHeight() {
		return employeeSignHeight;
	}

	public void setEmployeeSignHeight(int employeeSignHeight) {
		this.employeeSignHeight = employeeSignHeight;
	}

	public int getEmployeeSignWidth() {
		return employeeSignWidth;
	}

	public void setEmployeeSignWidth(int employeeSignWidth) {
		this.employeeSignWidth = employeeSignWidth;
	}

	public int getEmployerSignHeight() {
		return employerSignHeight;
	}

	public void setEmployerSignHeight(int employerSignHeight) {
		this.employerSignHeight = employerSignHeight;
	}

	public int getEmployerSignWidth() {
		return employerSignWidth;
	}

	public void setEmployerSignWidth(int employerSignWidth) {
		this.employerSignWidth = employerSignWidth;
	}

	public int getEmployeeXPosition() {
		return employeeXPosition;
	}

	public void setEmployeeXPosition(int employeeXPosition) {
		this.employeeXPosition = employeeXPosition;
	}

	public int getEmployeeYPosition() {
		return employeeYPosition;
	}

	public void setEmployeeYPosition(int employeeYPosition) {
		this.employeeYPosition = employeeYPosition;
	}

	public int getEmployerXPosition() {
		return employerXPosition;
	}

	public void setEmployerXPosition(int employerXPosition) {
		this.employerXPosition = employerXPosition;
	}

	public String getLegendUrl() {
		return legendUrl;
	}

	public void setLegendUrl(String legendUrl) {
		this.legendUrl = legendUrl;
	}

	public int getLegendXPosition() {
		return legendXPosition;
	}

	public void setLegendXPosition(int legendXPosition) {
		this.legendXPosition = legendXPosition;
	}

	public int getLegendYPosition() {
		return legendYPosition;
	}

	public void setLegendYPosition(int legendYPosition) {
		this.legendYPosition = legendYPosition;
	}

	public boolean isHasFirstOriginal() {
		return hasFirstOriginal;
	}

	public void setHasFirstOriginal(boolean hasFirstOriginal) {
		this.hasFirstOriginal = hasFirstOriginal;
	}

	public boolean isHasTwoPerPage() {
		return hasTwoPerPage;
	}

	public void setHasTwoPerPage(boolean hasTwoPerPage) {
		this.hasTwoPerPage = hasTwoPerPage;
	}

	public int getWhereToCutXPosition() {
		return whereToCutXPosition;
	}

	public void setWhereToCutXPosition(int whereToCutXPosition) {
		this.whereToCutXPosition = whereToCutXPosition;
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
		result = prime * result + ((auditData == null) ? 0 : auditData.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + (defaultConfiguration ? 1231 : 1237);
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + employeeSignHeight;
		result = prime * result + employeeSignWidth;
		result = prime * result + employeeXPosition;
		result = prime * result + employeeYPosition;
		result = prime * result + employerSignHeight;
		result = prime * result + employerSignWidth;
		result = prime * result + employerXPosition;
		result = prime * result + (hasDuplicate ? 1231 : 1237);
		result = prime * result + (hasFirstOriginal ? 1231 : 1237);
		result = prime * result + (hasLegend ? 1231 : 1237);
		result = prime * result + (hasTwoPerPage ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (landscaped ? 1231 : 1237);
		result = prime * result + ((legendUrl == null) ? 0 : legendUrl.hashCode());
		result = prime * result + legendXPosition;
		result = prime * result + legendYPosition;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + pageHeight;
		result = prime * result + pageWidth;
		result = prime * result + whereToCutXPosition;
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
		FileSplitAndSignConfiguration other = (FileSplitAndSignConfiguration) obj;
		if (auditData == null) {
			if (other.auditData != null)
				return false;
		} else if (!auditData.equals(other.auditData))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (defaultConfiguration != other.defaultConfiguration)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (employeeSignHeight != other.employeeSignHeight)
			return false;
		if (employeeSignWidth != other.employeeSignWidth)
			return false;
		if (employeeXPosition != other.employeeXPosition)
			return false;
		if (employeeYPosition != other.employeeYPosition)
			return false;
		if (employerSignHeight != other.employerSignHeight)
			return false;
		if (employerSignWidth != other.employerSignWidth)
			return false;
		if (employerXPosition != other.employerXPosition)
			return false;
		if (hasDuplicate != other.hasDuplicate)
			return false;
		if (hasFirstOriginal != other.hasFirstOriginal)
			return false;
		if (hasLegend != other.hasLegend)
			return false;
		if (hasTwoPerPage != other.hasTwoPerPage)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (landscaped != other.landscaped)
			return false;
		if (legendUrl == null) {
			if (other.legendUrl != null)
				return false;
		} else if (!legendUrl.equals(other.legendUrl))
			return false;
		if (legendXPosition != other.legendXPosition)
			return false;
		if (legendYPosition != other.legendYPosition)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pageHeight != other.pageHeight)
			return false;
		if (pageWidth != other.pageWidth)
			return false;
		if (whereToCutXPosition != other.whereToCutXPosition)
			return false;
		return true;
	}
	
}
