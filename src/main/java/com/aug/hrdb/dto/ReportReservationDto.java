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
		+ "reservation.ID AS id, "
		+ "reservation.START_TIME AS startTime, "
		+ "reservation.END_TIME AS endTime, "
		+ "reservation.DATE_RESERVATION AS dateReservation, "
		+ "reservation.DESCRIPTION AS description, "
		+ "reservation.RESERVATION_BY AS reservationBy, "
		+ "room.ID AS roomId, "	
		+ "room.Name AS roomName, "	
		+ "masreservationtype.ID AS reservationTypeId, "
		+ "masreservationtype.NAME AS reservationTypeName, "
		+ "masdivision.ID AS divisionId, "
		+ "masdivision.NAME AS divisionName "
		+ "FROM RESERVATION reservation "
		+ "LEFT JOIN ROOM room ON reservation.ROOM_ID = room.ID "
		+ "LEFT JOIN MAS_RESERVATION_TYPE masreservationtype ON reservation.RESERVATION_TYPE_ID = masreservationtype.ID "
		+ "LEFT JOIN MAS_DIVISION masdivision ON reservation.DIVISION_ID = masdivision.ID "
		+ "WHERE reservation.RESERVATION_BY like :RESERVATION_BY", resultClass = ReportReservationDto.class)

})
@Entity
public class ReportReservationDto {
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "startTime")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Bangkok")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;
	
	@Column(name = "endTime")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Bangkok")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endTime;
	
	@Column(name="dateReservation")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "en", timezone = "GMT")	
	@Temporal(TemporalType.DATE)
	private Date dateReservation;
	
	@Column(name="description",nullable = false)
	private String description;
	
	@Column(name="reservationBy",nullable = false)
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

	public String getReservationTypeName() {
		return reservationTypeName;
	}

	public void setReservationTypeName(String reservationTypeName) {
		this.reservationTypeName = reservationTypeName;
	}

	public Integer getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(Integer divisionId) {
		this.divisionId = divisionId;
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
