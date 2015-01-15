package com.minder.rece.domain;

import java.util.Set;

public class User {
	
	private String name;
	
	private String surname;
	
	private String email;
	
	private String username;
	
	private Password password;
	
	private Set<Signer> signers;
	
	private Set<RoleAssignment> roles;

}
