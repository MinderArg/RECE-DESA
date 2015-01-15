package com.minder.rece.domain;

import java.util.HashSet;
import java.util.Set;



public class Holding {
	
	private String name;
	
	private String address;
	
	private String uniqueHoldingKey;
	
	private Country country;
	
	private Set<Credit> credits;
	
	private Set<Company> companies;
	
}
