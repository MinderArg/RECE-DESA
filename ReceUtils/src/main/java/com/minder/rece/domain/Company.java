package com.minder.rece.domain;

import java.util.HashSet;
import java.util.Set;

public class Company {
	
	private String name;
	
	private String address;
	
	private String uniqueCompanyKey;
	
	private String uriLogo;
	
	private Set<Headquarter> headquarters;
	
	private Set<Liquidation> liquidations;
	
	private Set<CompanySigner> companySigner;
	
	private Holding holding;

}
