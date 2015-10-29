/**
 *
 * @author natechanok
 * @date Oct 28, 2015
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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@NamedNativeQueries({
	@NamedNativeQuery(name="GET_RESERVATIONS",
		query = "SELECT ID,START_TIME,END_TIME,DESCRIPTION as TITLE, null as DESCRIPTION, "+
				"null as RELATION_NAME, null as DIVISION_NAME, null as DATE_RESERVATION, "+
				"null as ROOM_NAME FROM RESERVATION "+
	            "r WHERE DATE(r.`START_TIME`) >= STR_TO_DATE(:START,'%Y-%m-%d') "+
				"AND  DATE(r.`END_TIME`) <= STR_TO_DATE(:END,'%Y-%m-%d')",
		resultClass = ReservationDto.class),
			
	@NamedNativeQuery(name="GET_RESERVATION_ID",
		query = "SELECT r.ID, START_TIME, END_TIME, DATE_RESERVATION, r.DESCRIPTION as TITLE, "+
				"ro.NAME as ROOM_NAME, mr.NAME as RESERVATION_TYPE, md.NAME as DIVISION_NAME, r.DESCRIPTION FROM RESERVATION r "+
				"LEFT JOIN MAS_RESERVATION_TYPE mr ON r.RESERVATION_TYPE_ID = mr.ID "+
				"LEFT JOIN ROOM ro ON r.ROOM_ID = ro.ID "+
				"LEFT JOIN EMPLOYEE e ON r.EMPLOYEE_ID = e.ID "+
				"LEFT JOIN MAS_DIVISION md ON e.DIVISION_ID = md.ID "+
				"LEFT JOIN APPLICANT app ON e.APPLICANT_ID = app.ID "+
				"WHERE r.ID = :SEARCH_ID ",
		resultClass = ReservationDto.class)			
					
					
					
	
})
public class ReservationDto {

	@Id
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "START_TIME")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Bangkok")
	@Temporal(TemporalType.TIMESTAMP)
	private Date start;
	
	@Column(name = "END_TIME")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Bangkok")
	@Temporal(TemporalType.TIMESTAMP)
	private Date end;
	
	@Column(name="DATE_RESERVATION")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "en", timezone = "GMT")	
	private Date dateReservation;
	
	@Column(name="TITLE")
	private String title;
	
	
	@Column(name="ROOM_NAME")
	private String roomName;
	
	@Column(name="RESERVATION_TYPE")
	private String reservationType;
	
	@Column(name="DIVISION_NAME")
	private String divisionName;
	
	@Column(name="DESCRIPTION")
	private String description;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String description) {
		this.title = description;
	}

	public Date getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	

	public String getReservationType() {
		return reservationType;
	}

	public void setReservationType(String reservationType) {
		this.reservationType = reservationType;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
