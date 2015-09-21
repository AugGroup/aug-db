package com.aug.hrdb.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;


@NamedNativeQueries({
	@NamedNativeQuery(
			name = "searchPunish",
			query= "select punish.id, "
					+ "punish.datepunish, "
					+ "punish.description, "
					+ "punish.penalty, "
					+ "punish.employee_id "
					+ "from emp_punish as punish,employee as emp "
					+ "where punish.employee_id =:empId and punish.employee_id=emp.id", 
			resultClass = PunsihDto.class)
	})

@Entity
public class PunsihDto {
	@Id
	@Column(name = "ID")
	private Integer id;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Column(name ="DATEPUNISH")
	//@Temporal(TemporalType.TIMESTAMP)
	private Date datepunish;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "PENALTY" )
	private String penalty;
	
	@Column(name ="EMPLOYEE_ID")
	private Integer employeeId;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDatepunish() {
		return datepunish;
	}

	public void setDatepunish(Date datepunish) {
		this.datepunish = datepunish;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getPenalty() {
		return penalty;
	}

	public void setPenalty(String penalty) {
		this.penalty = penalty;
	}


	


}
