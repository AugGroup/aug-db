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

import com.aug.hrdb.dto.CardDto;
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "CARD")
public class Card {
	
		
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "CARDNO" ,nullable = false)
	@NotEmpty 
	private String card_no;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="DD-MM-YYYY")
	@Column(name = "START_DATE" ,nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date startdate;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="DD-MM-YYYY")
	@Column(name = "END_DATE"  ,nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date enddate;
	
	@Column(name = "STATUS" ,nullable = false)
	@NotEmpty
	private String status;
	
	@Column(name = "REMARK")	
	private String remark;

	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "EMPLOYEE_ID" ,referencedColumnName="id", nullable=false)
//	@JsonIgnore
	private Employee employee;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCard_no() {
		return card_no;
	}

	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	public CardDto toCardDto(){
		CardDto cardDto = new CardDto();
		cardDto.setId(this.id);
		cardDto.setCard_no(this.card_no);
		cardDto.setStartdate(this.startdate);
		cardDto.setEnddate(this.enddate);
		cardDto.setStatus(this.status);
		cardDto.setRemark(this.remark);
		cardDto.setEmployeeId(this.employee.getId());
		return cardDto;
	}
	
	public Card fromCardDto(Card card,CardDto cardDto){
		card.setId(cardDto.getId());
		card.setCard_no(cardDto.getCard_no());
		card.setStartdate(cardDto.getStartdate());
		card.setEnddate(cardDto.getEnddate());
		card.setStatus(cardDto.getStatus());
		card.setRemark(cardDto.getRemark());
		
		Employee employee = new Employee();
		employee.setId(cardDto.getEmployeeId());
		card.setEmployee(employee);
		return card;
		
	}

}
