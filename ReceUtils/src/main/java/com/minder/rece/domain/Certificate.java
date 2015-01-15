package com.minder.rece.domain;

import javax.persistence.*;

@Entity
@Table(name = "certificates")
public class Certificate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String allAttr;
	
	private String uriPrivateCert;
	
	private String uriPublicCert;

	@ManyToOne
	@JoinColumn(name = "certificate_type_id")
	private CertificateType certificateType;

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
	
}
