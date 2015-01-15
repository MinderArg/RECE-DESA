package com.minder.rece.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "liquidation_file")
public class LiquidationFile {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="status_id")
	private LiquidationFileStatus status;
	
	private String name;
	
	private String uri;
	
//	@ManyToOne
//	@JoinColumn(name="id_company_signer")
//	private CompanySigner companySigner;
//	
//	@ManyToOne
//	@JoinColumn(name="id_liquidation")
//	private Liquidation liquidation;
//
//	@OneToMany
//	private Set<Receipt> receipts;
//	
//	
//
//	public CompanySigner getCompanySigner() {
//		return companySigner;
//	}
//
//	public void setCompanySigner(CompanySigner companySigner) {
//		this.companySigner = companySigner;
//	}
//
//	public Liquidation getLiquidation() {
//		return liquidation;
//	}
//
//	public void setLiquidation(Liquidation liquidation) {
//		this.liquidation = liquidation;
//	}
//
//	public Set<Receipt> getReceipts() {
//		return receipts;
//	}
//
//	public void setReceipts(Set<Receipt> receipts) {
//		this.receipts = receipts;
//	}

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

	public LiquidationFileStatus getStatus() {
		return status;
	}

	public void setStatus(LiquidationFileStatus status) {
		this.status = status;
	}

}
