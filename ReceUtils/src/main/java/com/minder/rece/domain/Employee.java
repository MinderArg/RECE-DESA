package com.minder.rece.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Employee extends Signer {
	
	private String uniqueEmployeeKey;
	
	private String employeeFileId;
	
	private String corporateEmail;
	
	private String mobilePhone;
	
	private Set<Receipt> receipts;
	
    //private Headquarter headquarter;
}
