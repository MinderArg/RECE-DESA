package com.minder.rece.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "tokens")
public class Token implements Serializable{

	private static final long serialVersionUID = -8032051652895957745L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "token_number")
	private String tokenNumber;

	@ManyToOne
	@JoinColumn(name = "token_type_id")
	private TokenType tokenType;
	
	@Embedded
	private AuditData auditData;
	
	@Embedded
	private Period activePeriod;
	
	public Period getActivePeriod() {
		return activePeriod;
	}

	public void setActivePeriod(Period activePeriod) {
		this.activePeriod = activePeriod;
	}

	public AuditData getAuditData() {
		return auditData;
	}

	public void setAuditData(AuditData auditData) {
		this.auditData = auditData;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTokenNumber() {
		return tokenNumber;
	}

	public void setTokenNumber(String tokenNumber) {
		this.tokenNumber = tokenNumber;
	}

	public TokenType getTokenType() {
		return tokenType;
	}

	public void setTokenType(TokenType tokenType) {
		this.tokenType = tokenType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activePeriod == null) ? 0 : activePeriod.hashCode());
		result = prime * result + ((auditData == null) ? 0 : auditData.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((tokenNumber == null) ? 0 : tokenNumber.hashCode());
		result = prime * result + ((tokenType == null) ? 0 : tokenType.hashCode());
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
		Token other = (Token) obj;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tokenNumber == null) {
			if (other.tokenNumber != null)
				return false;
		} else if (!tokenNumber.equals(other.tokenNumber))
			return false;
		if (tokenType == null) {
			if (other.tokenType != null)
				return false;
		} else if (!tokenType.equals(other.tokenType))
			return false;
		return true;
	}

}
