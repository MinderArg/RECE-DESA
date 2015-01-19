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

	@ManyToOne
	@JoinColumn(name = "signer_id")
	private Signer signer;
	
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Signer getSigner() {
		return signer;
	}

	public void setSigner(Signer signer) {
		this.signer = signer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((browserWhereSigned == null) ? 0 : browserWhereSigned.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ipWhereSigned == null) ? 0 : ipWhereSigned.hashCode());
		result = prime * result + ((signer == null) ? 0 : signer.hashCode());
		result = prime * result + ((wasDownloaded == null) ? 0 : wasDownloaded.hashCode());
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
		SignedReceipt other = (SignedReceipt) obj;
		if (browserWhereSigned == null) {
			if (other.browserWhereSigned != null)
				return false;
		} else if (!browserWhereSigned.equals(other.browserWhereSigned))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ipWhereSigned == null) {
			if (other.ipWhereSigned != null)
				return false;
		} else if (!ipWhereSigned.equals(other.ipWhereSigned))
			return false;
		if (signer == null) {
			if (other.signer != null)
				return false;
		} else if (!signer.equals(other.signer))
			return false;
		if (wasDownloaded == null) {
			if (other.wasDownloaded != null)
				return false;
		} else if (!wasDownloaded.equals(other.wasDownloaded))
			return false;
		return true;
	}

	
}
