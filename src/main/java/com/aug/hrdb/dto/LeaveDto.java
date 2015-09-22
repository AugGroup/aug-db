/**
 *
 * @author Pranrajit
 * @date 25 พ.ค. 2558
 */
package com.aug.hrdb.dto;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@NamedNativeQueries({
	@NamedNativeQuery(
			name="searchLeave",
					query="select l.id,l.aim,l.start_time,l.end_time,l.reason, m.name, l.employee_id, emp.employee_code, m.leavetype_id,aim.NAME_ENG as NAME_ENG,l.STARTTIMESTRING,l.ENDTIMESTRING "
							+ "from LEAVES l, EMPLOYEE emp,MAS_LEAVETYPE  m , (select  e.NAME_ENG as NAME_ENG,l.ID as id from EMP_LEAVE l join EMPLOYEE e on e.ID=l.AIM where l.AIM=e.ID) aim "
							+ "where  l.employee_id = :empId and l.employee_id = emp.id and l.leavetype_id = m.leavetype_id and aim.id=l.id",																																																																					
							resultClass = LeaveDto.class),
			 

	
		  })
			


@Entity
public class LeaveDto {

	@Column(name ="ID")
	@Id
	private Integer id;

	
	/*@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_DATE")
	private Date startDate;
	
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "END_DATE")
	private Date endDate;
	*/
	
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:mm a")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="START_TIME")
	private Date startTime;
	
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:mm a")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="END_TIME")
	private Date endTime;
	
	
	@Column(name="REASON")
	private String reason;
	
	@Column(name = "NAME")
	private String masleavetype;
	
	
	@Column(name = "EMPLOYEE_ID")
	private Integer employeeId;
	
	@Column(name = "EMPLOYEE_CODE")
	private String employeeCode;
	

	@Column(name = "LEAVETYPE_ID")
	private Integer masleavetypeId;

	
	@Column(name="AIM")
	private String aim;
	
	@Column(name="NAME_ENG")
	private String nameEng;
	
	@Column(name="STARTTIMESTRING")
	private String startTimeString;
	
	
	
	@Column(name="ENDTIMESTRING")
	private String endTimeString;
	
	
	


	
	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


/*
	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

*/
	public Date getStartTime() {
		return startTime;
	}


	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}


	public Date getEndTime() {
		return endTime;
	}


	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public String getMasleavetype() {
		return masleavetype;
	}


	public void setMasleavetype(String masleavetype) {
		this.masleavetype = masleavetype;
	}


	public Integer getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}


	public String getEmployeeCode() {
		return employeeCode;
	}


	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}


	public Integer getMasleavetypeId() {
		return masleavetypeId;
	}


	public void setMasleavetypeId(Integer masleavetypeId) {
		this.masleavetypeId = masleavetypeId;
	}


	public String getAim() {
		return aim;
	}


	public void setAim(String aim) {
		this.aim = aim;
	}


	public String getNameEng() {
		return nameEng;
	}


	public void setNameEng(String nameEng) {
		this.nameEng = nameEng;
	}


	public String getStartTimeString() {
		return startTimeString;
	}


	public void setStartTimeString(String startTimeString) {
		this.startTimeString = startTimeString;
	}


	public String getEndTimeString() {
		return endTimeString;
	}


	public void setEndTimeString(String endTimeString) {
		this.endTimeString = endTimeString;
	}


	

	/*public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


*/



	
	
}
