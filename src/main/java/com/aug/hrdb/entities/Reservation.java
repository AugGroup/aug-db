/**
 *
 * @author Pranrajit
 * @date 27 ต.ค. 2558
 */
package com.aug.hrdb.entities;

import java.util.Date;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="RESERVATION")

public class Reservation extends BaseEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;
	
	@Column(name = "START_TIME")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Bangkok")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss",iso = DateTimeFormat.ISO.NONE,style="MM")
	@Temporal(TemporalType.TIMESTAMP)
	private Date start;
	
	@Column(name = "END_TIME")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Bangkok")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss",iso = DateTimeFormat.ISO.NONE,style="MM")
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
	
	@ManyToOne
	@JoinColumn(name = "ROOM_ID", referencedColumnName = "id", nullable = false)
	private Room room;
	
	
	@ManyToOne
	@JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "id", nullable = true)
	private Employee employee;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "RESERVATION_TYPE_ID", referencedColumnName = "id", nullable = false)
	private MasReservationType masreservationtype;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "DIVISION_ID", referencedColumnName = "id", nullable = false)
	private MasDivision masDivision;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date startTime) {
		this.start = startTime;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date endTime) {
		this.end = endTime;
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

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public MasReservationType getMasreservationtype() {
		return masreservationtype;
	}

	public void setMasreservationtype(MasReservationType masreservationtype) {
		this.masreservationtype = masreservationtype;
	}

	public String getReservationBy() {
		return reservationBy;
	}

	public void setReservationBy(String reservationBy) {
		this.reservationBy = reservationBy;
	}

	public MasDivision getMasDivision() {
		return masDivision;
	}

	public void setMasDivision(MasDivision masDivision) {
		this.masDivision = masDivision;
	}

	
}
