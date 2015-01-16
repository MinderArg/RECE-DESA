package com.minder.rece.domain;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	private String surname;
	
	private String email;
	
	private String username;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Set<Password> passwords;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Set<RoleAssignment> roles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Password> getPasswords() {
		return passwords;
	}

	public void setPasswords(Set<Password> passwords) {
		this.passwords = passwords;
	}

	public Set<RoleAssignment> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleAssignment> roles) {
		this.roles = roles;
	}

}
