package com.minder.rece.domain;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	private String description;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "user_role_id")
	private Set<GrantedPermission> grantedPermissions;
	
	@Embedded
	private AuditData auditData;
	
	public AuditData getAuditData() {
		return auditData;
	}

	public void setAuditData(AuditData auditData) {
		this.auditData = auditData;
	}

	public Set<GrantedPermission> getGrantedPermissions() {
		return grantedPermissions;
	}

	public void setGrantedPermissions(Set<GrantedPermission> grantedPermissions) {
		this.grantedPermissions = grantedPermissions;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auditData == null) ? 0 : auditData.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((grantedPermissions == null) ? 0 : grantedPermissions.hashCode());
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
		UserRole other = (UserRole) obj;
		if (auditData == null) {
			if (other.auditData != null)
				return false;
		} else if (!auditData.equals(other.auditData))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (grantedPermissions == null) {
			if (other.grantedPermissions != null)
				return false;
		} else if (!grantedPermissions.equals(other.grantedPermissions))
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
