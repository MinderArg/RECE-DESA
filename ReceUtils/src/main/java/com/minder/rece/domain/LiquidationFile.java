package com.minder.rece.domain;


import javax.persistence.*;

@Entity
@Table(name = "liquidation_files")
public class LiquidationFile {

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

}
