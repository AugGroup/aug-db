package com.aug.hrdb.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@NamedNativeQueries({ @NamedNativeQuery(name = "REPORT_RESERVATION", query = "SELECT "
		+ "reservation.ID AS id,reservation.START_TIME AS start,reservation.END_TIME AS end,reservation.DATE_RESERVATION AS date,"
		+ "reservation.DESCRIPTION AS description,reservation.RESERVATION_BY AS reservationBy,reservation.ROOM_ID AS room,room.ID AS roomId,"
		+ "room.Name AS roomName,room.CAPACITY AS roomcapacity,room.DESCRIPTION AS roomdescription,reservation.RESERVATION_TYPE_ID AS masreservationtype,"
		+ "masreservationtype.ID AS masreservationtypeId,masreservationtype.NAME AS masreservationtypeName,reservation.DIVISION_ID AS masDivision,"
		+ "masdivision.ID AS masdivisionId,masdivision.NAME AS masdivisionName "
		+ "FROM RESERVATION reservation "
		+ "LEFT JOIN ROOM room ON reservation.ROOM_ID = room.ID "
		+ "LEFT JOIN MAS_RESERVATION_TYPE masreservationtype ON reservation.RESERVATION_TYPE_ID = masreservationtype.ID "
		+ "LEFT JOIN MAS_DIVISION masdivision ON reservation.DIVISION_ID = masdivision.ID ", resultClass = ReportReservationDto.class)
})
@Entity
public class ReportReservationDto {
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
	@Temporal(TemporalType.DATE)
	private Date dateReservation;
	
	@Column(name="DESCRIPTION",nullable = false)
	private String description;
	
	@Column(name="RESERVATION_BY",nullable = false)
	private String reservationBy;
	
	@Column(name = "reservationTypeId")
	private Integer reservationTypeId;
	
	@Column(name = "reservationTypeName")
	private String reservationTypeName;

	@Column(name = "divisionId")
	private Integer divisionId;
	
	@Column(name = "divisionName")
	private String divisionName;
	

	@Column(name = "roomId")
	private Integer roomId;
	
	@Column(name = "roomName")
	private String roomName;

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

	public Date getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReservationBy() {
		return reservationBy;
	}

	public void setReservationBy(String reservationBy) {
		this.reservationBy = reservationBy;
	}

	public Integer getReservationTypeId() {
		return reservationTypeId;
	}

	public void setReservationTypeId(Integer reservationTypeId) {
		this.reservationTypeId = reservationTypeId;
	}

	public Integer getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(Integer divisionId) {
		this.divisionId = divisionId;
	}

	public String getReservationTypeName() {
		return reservationTypeName;
	}

	public void setReservationTypeName(String reservationTypeName) {
		this.reservationTypeName = reservationTypeName;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	


}
