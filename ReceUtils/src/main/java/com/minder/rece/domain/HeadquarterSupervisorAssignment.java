package com.minder.rece.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "headquarter_supervisor_assignments")
public class HeadquarterSupervisorAssignment implements Serializable{

	private static final long serialVersionUID = -7331109694867831096L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activePeriod == null) ? 0 : activePeriod.hashCode());
		result = prime * result + ((auditData == null) ? 0 : auditData.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
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
		HeadquarterSupervisorAssignment other = (HeadquarterSupervisorAssignment) obj;
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
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
