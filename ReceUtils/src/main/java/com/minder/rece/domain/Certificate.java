package com.minder.rece.domain;

import javax.persistence.*;

@Entity
@Table(name = "certificates")
public class Certificate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name="all_attr")
	private String allAttr;

	@Column(name="uri_private_cert")
	private String uriPrivateCert;

	@Column(name="uri_public_cert")
	private String uriPublicCert;

	@ManyToOne
	@JoinColumn(name = "certificate_type_id")
	private CertificateType certificateType;
	
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

	public String getAllAttr() {
		return allAttr;
	}

	public void setAllAttr(String allAttr) {
		this.allAttr = allAttr;
	}

	public String getUriPrivateCert() {
		return uriPrivateCert;
	}

	public void setUriPrivateCert(String uriPrivateCert) {
		this.uriPrivateCert = uriPrivateCert;
	}

	public String getUriPublicCert() {
		return uriPublicCert;
	}

	public void setUriPublicCert(String uriPublicCert) {
		this.uriPublicCert = uriPublicCert;
	}

	public CertificateType getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(CertificateType certificateType) {
		this.certificateType = certificateType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activePeriod == null) ? 0 : activePeriod.hashCode());
		result = prime * result + ((allAttr == null) ? 0 : allAttr.hashCode());
		result = prime * result + ((auditData == null) ? 0 : auditData.hashCode());
		result = prime * result + ((certificateType == null) ? 0 : certificateType.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((uriPrivateCert == null) ? 0 : uriPrivateCert.hashCode());
		result = prime * result + ((uriPublicCert == null) ? 0 : uriPublicCert.hashCode());
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
		Certificate other = (Certificate) obj;
		if (activePeriod == null) {
			if (other.activePeriod != null)
				return false;
		} else if (!activePeriod.equals(other.activePeriod))
			return false;
		if (allAttr == null) {
			if (other.allAttr != null)
				return false;
		} else if (!allAttr.equals(other.allAttr))
			return false;
		if (auditData == null) {
			if (other.auditData != null)
				return false;
		} else if (!auditData.equals(other.auditData))
			return false;
		if (certificateType == null) {
			if (other.certificateType != null)
				return false;
		} else if (!certificateType.equals(other.certificateType))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (uriPrivateCert == null) {
			if (other.uriPrivateCert != null)
				return false;
		} else if (!uriPrivateCert.equals(other.uriPrivateCert))
			return false;
		if (uriPublicCert == null) {
			if (other.uriPublicCert != null)
				return false;
		} else if (!uriPublicCert.equals(other.uriPublicCert))
			return false;
		return true;
	}
	
}
