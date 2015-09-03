/**
 *
 * @author Pranrajit
 * @date 25 พ.ค. 2558
 */
package com.aug.hrdb.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="LEAVES")
public class Leave extends BaseEntity {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;
	
/*	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Column(name = "START_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	

	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Column(name = "END_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;*/
	

	/*@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="hh:mm:ss",timezone ="GMT+07:00")
	@Temporal(TemporalType.TIME)
	@Column(name="START_TIME")
	private  Date startTime;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="hh:mm:ss")
	@Temporal(TemporalType.TIME)
	@Column(name="END_TIME")
	private Date endTime;*/
	
	
	
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:mm a")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="START_TIME")
	private  Date startTime;
	
	//@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy hh:mm a")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="END_TIME")
	private Date endTime;
	
	
	@Column(name="REASON")
	private String reason;
	
	@Column(name="AIM",nullable = false)
	//@NotEmpty
	private String aim;
	
	
	/*@ManyToOne()
	@JoinColumn(name = "LEAVETYPE_ID",nullable = false,referencedColumnName="LEAVETYPE_ID")
	private MasLeaveType masleavetype;
	
	@ManyToOne()
	@JoinColumn(name = "EMPLOYEE_ID",nullable = false,referencedColumnName="id")
	private Employee employee;
	*/
	
	@Column(name="STARTTIMESTRING")
	private String startTimeString;
	
	@Column(name="ENDTIMESTRING")
	private String endTimeString;
	
	
	@Column(name="SUMTIME")
	private Integer sumTime;
	
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


/*	public Date getStartDate() {
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
	}*/

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

	/*public MasLeaveType getMasleavetype() {
		return masleavetype;
	}

	public void setMasleavetype(MasLeaveType masleavetype) {
		this.masleavetype = masleavetype;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
*/


	
	

	public String getAim() {
		return aim;
	}

	public void setAim(String aim) {
		this.aim = aim;
	}
	
	
	

	public String getStartTimeString() {
		return startTimeString;
	}

	public void setStartTimeString(String startTimeString) {
		this.startTimeString = startTimeString;
	}

	
	
	
	
/*	public Date getStartDate() {
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
	public String getEndTimeString() {
		return endTimeString;
	}

	public void setEndTimeString(String endTimeString) {
		this.endTimeString = endTimeString;
	}
	


	public Integer getSumTime() {
		return sumTime;
	}

	public void setSumTime(Integer sumTime) {
		this.sumTime = sumTime;
	}

	/*public LeaveDto toLeaveDto(){
		LeaveDto leaveDto = new LeaveDto();
		leaveDto.setId(this.id);
		//leaveDto.setStartDate(this.startDate);
		leaveDto.setStartTime(this.startTime);
		//leaveDto.setEndDate(this.endDate);
		leaveDto.setEndTime(this.endTime);
		leaveDto.setReason(this.reason);
		leaveDto.setAim(this.aim);
		leaveDto.setEmployeeCode(this.employee.getEmployeeCode());
		leaveDto.setEmployeeId(this.employee.getId());
		leaveDto.setMasleavetypeId(this.masleavetype.getId());
		leaveDto.setMasleavetype(this.masleavetype.getName());
		//leaveDto.setSumTime(this.sumTime);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		String startTime = formatter.format(this.startTime);
		leaveDto.setStartTimeString(startTime);
		
		SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		String endTime = formatter2.format(this.endTime);
		leaveDto.setEndTimeString(endTime);
		
		return leaveDto;
	}
	
	public Leave fromLeaveDto (LeaveDto leaveDto,Leave leave,Integer sumtime){
		//Leave leave = new Leave();
		//leave.setId(leaveDto.getId());
		//leave.setStartDate(leaveDto.getStartDate());
		leave.setStartTime(leaveDto.getStartTime());
		//leave.setEndDate(leaveDto.getEndDate());
		leave.setEndTime(leaveDto.getEndTime());
		leave.setReason(leaveDto.getReason());
		leave.setAim(leaveDto.getAim());
		leave.setSumTime(sumtime);
		System.out.println("sumtime: "+leave.getSumTime());
		
		
		
		MasLeaveType masleavetype=new MasLeaveType();
		masleavetype.setId(leaveDto.getMasleavetypeId());
		masleavetype.setName(leaveDto.getMasleavetype());
		leave.setMasleavetype(masleavetype);
		
		
		Employee employee = new Employee();
		employee.setId(leaveDto.getEmployeeId());
		leave.setEmployee(employee);
		
		SimpleDateFormat formatter = new SimpleDateFormat(" dd-MM-yyyy HH:mm");
		String starttime = formatter.format(this.startTime);
		leave.setStartTimeString(starttime);
		

		SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy HH:mm ");
		String endTime = formatter2.format(this.endTime);
		leave.setEndTimeString(endTime);
		
		
		return leave;
		
	}*/
	
}
