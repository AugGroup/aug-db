package com.aug.hrdb.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

import com.aug.hrdb.dto.PunsihDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "PUNISH")
public class Punish {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Column(name = "DATEPUNISH" ,nullable = false)
	//@Temporal(TemporalType.TIMESTAMP)
	private Date datepunish;
		
	@Column(name = "DESCRIPTION" ,nullable = false)
	@NotEmpty 
	private String description;
	
//	@ManyToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name="EMPLOYEE_ID" , referencedColumnName="id", nullable=true)
////	private Employee employee;

	@Column(name = "PENALTY" ,nullable = false)
	@NotEmpty 
	private String penalty;
	
	

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


//	public Employee getEmployee() {
//		return employee;
//	}
//
//
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}


	public String getPenalty() {
		return penalty;
	}


	public void setPenalty(String penalty) {
		this.penalty = penalty;
	}


	public PunsihDto toPunishDto(){
		PunsihDto punsihDto = new PunsihDto();
		punsihDto.setId(this.id);
		punsihDto.setDatepunish(this.datepunish);
		punsihDto.setDescription(this.description);
		punsihDto.setPenalty(this.penalty);
		punsihDto.setEmployeeId(this.getId());
		return punsihDto;
	}
	
	

	public Punish fromPunishDto(Punish punish,PunsihDto punsihDto){
		//Punish punish = new Punish();
		punish.setId(punsihDto.getId());
		punish.setDatepunish(punsihDto.getDatepunish());
		punish.setDescription(punsihDto.getDescription());
		punish.setPenalty(punsihDto.getPenalty());
		
//		Employee employee = new Employee();
//		employee.setId(punsihDto.getEmployeeId());
//		punish.setEmployee(employee);
		return punish;
		
	}
	
}
