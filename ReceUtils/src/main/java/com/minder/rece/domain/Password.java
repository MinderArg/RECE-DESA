package com.minder.rece.domain;

import javax.persistence.*;

@Entity
@Table(name = "passwords")
public class Password {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="encrypted_password")
	private String encryptedPassword;
	
	@Embedded
	private Period activePeriod;
	
	@Embedded
	private AuditData auditData;
	
	public AuditData getAuditData() {
		return auditData;
	}

	public void setAuditData(AuditData auditData) {
		this.auditData = auditData;
	}

	public Period getActivePeriod() {
		return activePeriod;
	}

	public void setActivePeriod(Period activePeriod) {
		this.activePeriod = activePeriod;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activePeriod == null) ? 0 : activePeriod.hashCode());
		result = prime * result + ((auditData == null) ? 0 : auditData.hashCode());
		result = prime * result + ((encryptedPassword == null) ? 0 : encryptedPassword.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Password other = (Password) obj;
		if (activePeriod == null) {
			if (other.activePeriod != null)
				return false;
		} else if (!activePeriod.equals(other.activePeriod))
			return false;
		if (auditData == null) {
			if (other.auditData != null)
				return false;
		} else if (!auditData.equals(other.auditData))
			return false;
		if (encryptedPassword == null) {
			if (other.encryptedPassword != null)
				return false;
		} else if (!encryptedPassword.equals(other.encryptedPassword))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
