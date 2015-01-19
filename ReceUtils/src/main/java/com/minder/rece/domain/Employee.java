package com.minder.rece.domain;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee extends Signer {

	@Column(name="unique_employee_key")
	private String uniqueEmployeeKey;

	@Column(name="employee_file_id")
	private String employeeFileId;

	@Column(name="corporate_email")
	private String corporateEmail;

	@Column(name="mobile_phone")
	private String mobilePhone; 

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "employee_id")
	private Set<Token> tokens;

	@OneToMany(mappedBy="employee", cascade=CascadeType.ALL)
	private Set<HeadquarterAssignment> headquarterAssignments;


	public Set<HeadquarterAssignment> getHeadquarterAssignments() {
		return headquarterAssignments;
	}

	public void setHeadquarterAssignments(Set<HeadquarterAssignment> headquarterAssignments) {
		this.headquarterAssignments = headquarterAssignments;
	}

	public Set<Token> getTokens() {
		return tokens;
	}

	public void setTokens(Set<Token> tokens) {
		this.tokens = tokens;
	}

	public String getUniqueEmployeeKey() {
		return uniqueEmployeeKey;
	}

	public void setUniqueEmployeeKey(String uniqueEmployeeKey) {
		this.uniqueEmployeeKey = uniqueEmployeeKey;
	}

	public String getEmployeeFileId() {
		return employeeFileId;
	}

	public void setEmployeeFileId(String employeeFileId) {
		this.employeeFileId = employeeFileId;
	}

	public String getCorporateEmail() {
		return corporateEmail;
	}

	public void setCorporateEmail(String corporateEmail) {
		this.corporateEmail = corporateEmail;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((corporateEmail == null) ? 0 : corporateEmail.hashCode());
		result = prime * result + ((employeeFileId == null) ? 0 : employeeFileId.hashCode());
		result = prime * result + ((headquarterAssignments == null) ? 0 : headquarterAssignments.hashCode());
		result = prime * result + ((mobilePhone == null) ? 0 : mobilePhone.hashCode());
		result = prime * result + ((tokens == null) ? 0 : tokens.hashCode());
		result = prime * result + ((uniqueEmployeeKey == null) ? 0 : uniqueEmployeeKey.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (corporateEmail == null) {
			if (other.corporateEmail != null)
				return false;
		} else if (!corporateEmail.equals(other.corporateEmail))
			return false;
		if (employeeFileId == null) {
			if (other.employeeFileId != null)
				return false;
		} else if (!employeeFileId.equals(other.employeeFileId))
			return false;
		if (headquarterAssignments == null) {
			if (other.headquarterAssignments != null)
				return false;
		} else if (!headquarterAssignments.equals(other.headquarterAssignments))
			return false;
		if (mobilePhone == null) {
			if (other.mobilePhone != null)
				return false;
		} else if (!mobilePhone.equals(other.mobilePhone))
			return false;
		if (tokens == null) {
			if (other.tokens != null)
				return false;
		} else if (!tokens.equals(other.tokens))
			return false;
		if (uniqueEmployeeKey == null) {
			if (other.uniqueEmployeeKey != null)
				return false;
		} else if (!uniqueEmployeeKey.equals(other.uniqueEmployeeKey))
			return false;
		return true;
	}
	
}
