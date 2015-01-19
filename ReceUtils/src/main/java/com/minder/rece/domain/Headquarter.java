package com.minder.rece.domain;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "headquarters")
public class Headquarter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	private String description;
	
	private String address;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	@OneToMany(mappedBy="headquarter", cascade=CascadeType.ALL)
	private Set<HeadquarterAssignment> headquarterAssignments;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "headquarter_id")
	private Set<HeadquarterSupervisorAssignment> headquarterSupervisorAssignments;
	
	
	public Set<HeadquarterSupervisorAssignment> getHeadquarterSupervisorAssignments() {
		return headquarterSupervisorAssignments;
	}

	public void setHeadquarterSupervisorAssignments(
			Set<HeadquarterSupervisorAssignment> headquarterSupervisorAssignments) {
		this.headquarterSupervisorAssignments = headquarterSupervisorAssignments;
	}

	public Set<HeadquarterAssignment> getHeadquarterAssignments() {
		return headquarterAssignments;
	}

	public void setHeadquarterAssignments(Set<HeadquarterAssignment> headquarterAssignments) {
		this.headquarterAssignments = headquarterAssignments;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((headquarterAssignments == null) ? 0 : headquarterAssignments.hashCode());
		result = prime
				* result
				+ ((headquarterSupervisorAssignments == null) ? 0 : headquarterSupervisorAssignments
						.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Headquarter other = (Headquarter) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (headquarterAssignments == null) {
			if (other.headquarterAssignments != null)
				return false;
		} else if (!headquarterAssignments.equals(other.headquarterAssignments))
			return false;
		if (headquarterSupervisorAssignments == null) {
			if (other.headquarterSupervisorAssignments != null)
				return false;
		} else if (!headquarterSupervisorAssignments.equals(other.headquarterSupervisorAssignments))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
