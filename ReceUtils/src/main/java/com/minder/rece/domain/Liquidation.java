package com.minder.rece.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Liquidation {
	private String name;
	private String period;
	private int amount;
	private Date creationDate;
	
	private Company company;
	private Set<LiquidationFile> files;
	
}
