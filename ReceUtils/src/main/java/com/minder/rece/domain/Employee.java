package com.minder.rece.domain;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee extends Signer {
	
	private String uniqueEmployeeKey;
	
	private String employeeFileId;
	
	private String corporateEmail;
	
	private String mobilePhone;

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
	
}
