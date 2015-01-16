package com.minder.rece.domain;

import javax.persistence.*;

@Entity
@Table(name = "signed_receipts")
public class SignedReceipt {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name="ip_where_signed")
	private String ipWhereSigned;

	@Column(name="browser_where_signed")
	private String browserWhereSigned;

	@Column(name="was_downloaded")
	private Boolean wasDownloaded;

	@Column(name="signed_by")
	private String signedBy;
	
	public String getIpWhereSigned() {
		return ipWhereSigned;
	}

	public void setIpWhereSigned(String ipWhereSigned) {
		this.ipWhereSigned = ipWhereSigned;
	}

	public String getBrowserWhereSigned() {
		return browserWhereSigned;
	}

	public void setBrowserWhereSigned(String browserWhereSigned) {
		this.browserWhereSigned = browserWhereSigned;
	}

	public Boolean getWasDownloaded() {
		return wasDownloaded;
	}

	public void setWasDownloaded(Boolean wasDownloaded) {
		this.wasDownloaded = wasDownloaded;
	}

	public String getSignedBy() {
		return signedBy;
	}

	public void setSignedBy(String signedBy) {
		this.signedBy = signedBy;
	}

	
}
