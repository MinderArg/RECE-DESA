package com.minder.rece.domain;


import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "liquidation_files")
public class LiquidationFile implements Serializable{

	private static final long serialVersionUID = 2466869008615855808L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "liquidation_file_status_id")
	private LiquidationFileStatus liquidationFileStatus;

	private String name;

	private String uri;

	@ManyToOne
	@JoinColumn(name = "id_company_signer")
	private CompanySigner companySigner;

	@ManyToOne
	@JoinColumn(name = "id_liquidation")
	private Liquidation liquidation;

	@ManyToOne
	@JoinColumn(name = "file_split_and_sign_configuration_id")
	private FileSplitAndSignConfiguration fileSplitAndSignConfiguration;
	
	@Embedded
	private AuditData auditData;
	
	public AuditData getAuditData() {
		return auditData;
	}

	public void setAuditData(AuditData auditData) {
		this.auditData = auditData;
	}

	public FileSplitAndSignConfiguration getFileSplitAndSignConfiguration() {
		return fileSplitAndSignConfiguration;
	}

	public void setFileSplitAndSignConfiguration(FileSplitAndSignConfiguration fileSplitAndSignConfiguration) {
		this.fileSplitAndSignConfiguration = fileSplitAndSignConfiguration;
	}

	public CompanySigner getCompanySigner() {
		return companySigner;
	}

	public void setCompanySigner(CompanySigner companySigner) {
		this.companySigner = companySigner;
	}

	public Liquidation getLiquidation() {
		return liquidation;
	}

	public void setLiquidation(Liquidation liquidation) {
		this.liquidation = liquidation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LiquidationFileStatus getLiquidationFileStatus() {
		return liquidationFileStatus;
	}

	public void setLiquidationFileStatus(LiquidationFileStatus liquidationFileStatus) {
		this.liquidationFileStatus = liquidationFileStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auditData == null) ? 0 : auditData.hashCode());
		result = prime * result + ((companySigner == null) ? 0 : companySigner.hashCode());
		result = prime * result
				+ ((fileSplitAndSignConfiguration == null) ? 0 : fileSplitAndSignConfiguration.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((liquidation == null) ? 0 : liquidation.hashCode());
		result = prime * result + ((liquidationFileStatus == null) ? 0 : liquidationFileStatus.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
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
		LiquidationFile other = (LiquidationFile) obj;
		if (auditData == null) {
			if (other.auditData != null)
				return false;
		} else if (!auditData.equals(other.auditData))
			return false;
		if (companySigner == null) {
			if (other.companySigner != null)
				return false;
		} else if (!companySigner.equals(other.companySigner))
			return false;
		if (fileSplitAndSignConfiguration == null) {
			if (other.fileSplitAndSignConfiguration != null)
				return false;
		} else if (!fileSplitAndSignConfiguration.equals(other.fileSplitAndSignConfiguration))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (liquidation == null) {
			if (other.liquidation != null)
				return false;
		} else if (!liquidation.equals(other.liquidation))
			return false;
		if (liquidationFileStatus == null) {
			if (other.liquidationFileStatus != null)
				return false;
		} else if (!liquidationFileStatus.equals(other.liquidationFileStatus))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (uri == null) {
			if (other.uri != null)
				return false;
		} else if (!uri.equals(other.uri))
			return false;
		return true;
	}

}
