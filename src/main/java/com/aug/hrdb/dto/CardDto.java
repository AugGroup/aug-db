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
            name = "searchCard",
            query = "select card.id, "
            		+ "card.cardno, "
            		+ "card.start_date, "
            		+ "card.end_date, "
            		+ "card.status, "
            		+ "card.remark, "
            		+ "card.employee_id "
            		+ "from card,emp_employee as emp "
            		+ "where card.employee_id =:empId and card.employee_id=emp.id",
            resultClass = CardDto.class),
})

@Entity
public class CardDto {
	

	@Column(name = "ID")
	@Id
	private Integer id;	
	
	@Column(name = "CARDNO")
	private String card_no;
	
	@Column(name = "START_DATE")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")	
	@Temporal(TemporalType.TIMESTAMP)
	private Date startdate;
	
	@Column(name = "END_DATE")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	private Date enddate;
	
	@Column(name = "STATUS")
	private String status;
	@Column(name = "REMARK")
	private String remark;
    @Column(name = "EMPLOYEE_ID")
	private Integer employeeId;
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
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	
    

}
