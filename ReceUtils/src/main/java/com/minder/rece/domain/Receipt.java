package com.minder.rece.domain;

public class Receipt {
	
	private String uriSplittedEmployee;
	
	private String uriSplittedCompany;
	
	private SignedReceipt signedByCompany; 
	
	private SignedReceipt signedByEmployeeConf; 
	
	private SignedReceipt signedByEmployeeNoConf; 
	
	private Employee employee;
	
	private LiquidationFile file;

}
