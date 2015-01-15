package com.minder.rece.domain;

import javax.persistence.*;

@Entity
@Table(name = "receipts")
public class Receipt {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String uriSplittedEmployee;
	
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

}
