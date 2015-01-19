package com.minder.rece.domain;

import javax.persistence.*;

@Entity
@Table(name = "receipts")
public class Receipt {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name="uri_splitted_employee")
	private String uriSplittedEmployee;

	@Column(name="uri_splitted_company")
	private String uriSplittedCompany;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "receipt_signed_by_company_id")
	private SignedReceipt receiptSignedByCompany; 

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "receipt_signed_by_employee_conf_id")
	private SignedReceipt receiptSignedByEmployeeConf; 

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "receipt_signed_by_employee_no_conf_id")
	private SignedReceipt receiptSignedByEmployeeNoConf; 

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	@ManyToOne
	@JoinColumn(name = "liquidation_file_id")
	private LiquidationFile file;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUriSplittedEmployee() {
		return uriSplittedEmployee;
	}

	public void setUriSplittedEmployee(String uriSplittedEmployee) {
		this.uriSplittedEmployee = uriSplittedEmployee;
	}

	public String getUriSplittedCompany() {
		return uriSplittedCompany;
	}

	public void setUriSplittedCompany(String uriSplittedCompany) {
		this.uriSplittedCompany = uriSplittedCompany;
	}

	public SignedReceipt getReceiptSignedByCompany() {
		return receiptSignedByCompany;
	}

	public void setReceiptSignedByCompany(SignedReceipt receiptSignedByCompany) {
		this.receiptSignedByCompany = receiptSignedByCompany;
	}

	public SignedReceipt getReceiptSignedByEmployeeConf() {
		return receiptSignedByEmployeeConf;
	}

	public void setReceiptSignedByEmployeeConf(SignedReceipt receiptSignedByEmployeeConf) {
		this.receiptSignedByEmployeeConf = receiptSignedByEmployeeConf;
	}

	public SignedReceipt getReceiptSignedByEmployeeNoConf() {
		return receiptSignedByEmployeeNoConf;
	}

	public void setReceiptSignedByEmployeeNoConf(SignedReceipt receiptSignedByEmployeeNoConf) {
		this.receiptSignedByEmployeeNoConf = receiptSignedByEmployeeNoConf;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public LiquidationFile getFile() {
		return file;
	}

	public void setFile(LiquidationFile file) {
		this.file = file;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((file == null) ? 0 : file.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((receiptSignedByCompany == null) ? 0 : receiptSignedByCompany.hashCode());
		result = prime * result
				+ ((receiptSignedByEmployeeConf == null) ? 0 : receiptSignedByEmployeeConf.hashCode());
		result = prime * result
				+ ((receiptSignedByEmployeeNoConf == null) ? 0 : receiptSignedByEmployeeNoConf.hashCode());
		result = prime * result + ((uriSplittedCompany == null) ? 0 : uriSplittedCompany.hashCode());
		result = prime * result + ((uriSplittedEmployee == null) ? 0 : uriSplittedEmployee.hashCode());
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
		Receipt other = (Receipt) obj;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (file == null) {
			if (other.file != null)
				return false;
		} else if (!file.equals(other.file))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (receiptSignedByCompany == null) {
			if (other.receiptSignedByCompany != null)
				return false;
		} else if (!receiptSignedByCompany.equals(other.receiptSignedByCompany))
			return false;
		if (receiptSignedByEmployeeConf == null) {
			if (other.receiptSignedByEmployeeConf != null)
				return false;
		} else if (!receiptSignedByEmployeeConf.equals(other.receiptSignedByEmployeeConf))
			return false;
		if (receiptSignedByEmployeeNoConf == null) {
			if (other.receiptSignedByEmployeeNoConf != null)
				return false;
		} else if (!receiptSignedByEmployeeNoConf.equals(other.receiptSignedByEmployeeNoConf))
			return false;
		if (uriSplittedCompany == null) {
			if (other.uriSplittedCompany != null)
				return false;
		} else if (!uriSplittedCompany.equals(other.uriSplittedCompany))
			return false;
		if (uriSplittedEmployee == null) {
			if (other.uriSplittedEmployee != null)
				return false;
		} else if (!uriSplittedEmployee.equals(other.uriSplittedEmployee))
			return false;
		return true;
	}

}
