package com.minder.rece.domain;

import javax.persistence.*;

@Entity
@Table(name = "signed_receipts")
public class SignedReceipt {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String ipWhereSigned;
	
	private String browserWhereSigned;
	
	private String wasDownloaded;

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

	public String getWasDownloaded() {
		return wasDownloaded;
	}

	public void setWasDownloaded(String wasDownloaded) {
		this.wasDownloaded = wasDownloaded;
	}

	public String getSignedBy() {
		return signedBy;
	}

	public void setSignedBy(String signedBy) {
		this.signedBy = signedBy;
	}

	
}
