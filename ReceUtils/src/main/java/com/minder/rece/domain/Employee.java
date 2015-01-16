package com.minder.rece.domain;

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
