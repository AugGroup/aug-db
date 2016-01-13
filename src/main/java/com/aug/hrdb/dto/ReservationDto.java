/**
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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@NamedNativeQueries({
  @NamedNativeQuery(
    name = "GET_RESERVATIONS",
    query = "SELECT r.ID, r.START_TIME, r.END_TIME, r.DESCRIPTION as TITLE, r.DESCRIPTION, null as ROOM_ID, " +
      "null as RELATION_NAME, null as DIVISION_NAME, null as DATE_RESERVATION, null as RESERVATION_TYPE, " +
      "r.EMPLOYEE_ID, " +
      "null as ROOM_NAME ,ro.COLOR as COLOR , a.FIRSTNAME_EN, a.LASTNAME_EN " +
      "FROM RESERVATION r " +
      "LEFT JOIN ROOM ro ON r.ROOM_ID = ro.ID " +
      "LEFT JOIN EMPLOYEE e ON r.EMPLOYEE_ID = e.ID " +
      "LEFT JOIN APPLICANT a ON e.APPLICANT_ID = a.ID " +
      "WHERE DATE(r.`START_TIME`) >= STR_TO_DATE(:START,'%Y-%m-%d') " +
      "AND  DATE(r.`END_TIME`) <= STR_TO_DATE(:END,'%Y-%m-%d')  ",
    resultClass = ReservationDto.class),

  @NamedNativeQuery(
    name = "GET_RESERVATION_ID",
    query = "SELECT r.ID, r.START_TIME, r.END_TIME, r.DATE_RESERVATION, r.DESCRIPTION as TITLE,null as ROOM_ID, " +
      "ro.NAME as ROOM_NAME, mr.NAME as RESERVATION_TYPE, md.NAME as DIVISION_NAME, " +
      "r.DESCRIPTION,ro.COLOR as COLOR, r.EMPLOYEE_ID, a.FIRSTNAME_EN, a.LASTNAME_EN  FROM RESERVATION r " +
      "LEFT JOIN MAS_RESERVATION_TYPE mr ON r.RESERVATION_TYPE_ID = mr.ID " +
      "LEFT JOIN ROOM ro ON r.ROOM_ID = ro.ID " +
      "LEFT JOIN EMPLOYEE e ON r.EMPLOYEE_ID = e.ID " +
      "LEFT JOIN APPLICANT a ON e.APPLICANT_ID = a.ID " +
      "LEFT JOIN MAS_DIVISION md ON r.DIVISION_ID = md.ID " +
      "LEFT JOIN APPLICANT app ON e.APPLICANT_ID = app.ID " +
      "WHERE r.ID = :SEARCH_ID ",

    resultClass = ReservationDto.class),

  @NamedNativeQuery(
    name = "SEARCH_RESERVATION",
    query = "SELECT r.ID, r.START_TIME, r.END_TIME, r.DATE_RESERVATION, null as TITLE, " +
      "ro.NAME as ROOM_NAME, mr.NAME as RESERVATION_TYPE, md.NAME as DIVISION_NAME, " +
      "null as DESCRIPTION ,null as ROOM_ID, a.FIRSTNAME_EN, a.LASTNAME_EN,ro.COLOR as COLOR, " +
      "null as EMPLOYEE_ID FROM RESERVATION r " +
      "LEFT JOIN ROOM ro ON r.ROOM_ID = ro.ID " +
      "LEFT JOIN MAS_DIVISION md ON r.DIVISION_ID = md.ID " +
      "LEFT JOIN MAS_RESERVATION_TYPE mr ON r.RESERVATION_TYPE_ID = mr.ID " +
      "LEFT JOIN EMPLOYEE e ON r.EMPLOYEE_ID = e.ID " +
      "LEFT JOIN APPLICANT a ON e.APPLICANT_ID = a.ID " +
      "WHERE 1=1 ",
    resultClass = ReservationDto.class),

  @NamedNativeQuery(
    name = "FILTER_RESERVATIONS",
    query = "SELECT r.ID,r.START_TIME,r.END_TIME,r.DESCRIPTION as TITLE, r.DESCRIPTION,null as ROOM_ID, " +
      "null as RELATION_NAME, null as DIVISION_NAME, null as DATE_RESERVATION, null as RESERVATION_TYPE, " +
      "null as ROOM_NAME ,null as EMPLOYEE_ID, a.FIRSTNAME_EN, a.LASTNAME_EN, ro.COLOR as COLOR FROM RESERVATION r " +
      "LEFT JOIN ROOM ro ON r.ROOM_ID = ro.ID " +
      "LEFT JOIN EMPLOYEE e ON r.EMPLOYEE_ID = e.ID " +
      "LEFT JOIN APPLICANT a ON e.APPLICANT_ID = a.ID " +
      "WHERE DATE(r.`START_TIME`) >= STR_TO_DATE(:START,'%Y-%m-%d') " +
      "AND  DATE(r.`END_TIME`) <= STR_TO_DATE(:END,'%Y-%m-%d') ",
    resultClass = ReservationDto.class),

  @NamedNativeQuery(
    name = "GET_RESERVATION_BY_TIMESTAMP",
    query = "SELECT r.ID, r.START_TIME, r.END_TIME, r.DESCRIPTION as TITLE, r.DESCRIPTION, r.ROOM_ID, " +
      "null as RELATION_NAME, null as DIVISION_NAME, null as DATE_RESERVATION, null as RESERVATION_TYPE, " +
      "null as ROOM_NAME ,null as EMPLOYEE_ID, null as FIRSTNAME_EN, null as LASTNAME_EN ," +
      "ro.COLOR as COLOR FROM RESERVATION r LEFT JOIN ROOM ro ON r.ROOM_ID = ro.ID " +
      "WHERE STR_TO_DATE(:NEW,'%Y-%m-%d %H:%i:%s') > r.START_TIME AND STR_TO_DATE(:NEW,'%Y-%m-%d %H:%i:%s') < r.END_TIME AND r.ROOM_ID = :ROOM",
    resultClass = ReservationDto.class),

  @NamedNativeQuery(
    name = "GET_BETWEEN_RESERVATION",
    query = "SELECT r.ID,r.START_TIME,r.END_TIME,r.DESCRIPTION as TITLE, r.DESCRIPTION, r.ROOM_ID, " +
      "null as RELATION_NAME, null as DIVISION_NAME, null as DATE_RESERVATION, null as RESERVATION_TYPE, " +
      "null as ROOM_NAME ,null as EMPLOYEE_ID, null as FIRSTNAME_EN, null as LASTNAME_EN ,ro.COLOR as COLOR FROM RESERVATION r " +
      "LEFT JOIN ROOM ro ON r.ROOM_ID = ro.ID " +
      "WHERE STR_TO_DATE(:START,'%Y-%m-%d %H:%i:%s') <= r.START_TIME AND STR_TO_DATE(:END,'%Y-%m-%d %H:%i:%s') >= r.END_TIME AND r.ROOM_ID = :ROOM",
    resultClass = ReservationDto.class)
})
public class ReservationDto {

  @Id
  @Column(name = "ID")
  private Integer id;

  @Column(name = "START_TIME")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Bangkok")
  @Temporal(TemporalType.TIMESTAMP)
  private Date start;

  @Column(name = "END_TIME")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Bangkok")
  @Temporal(TemporalType.TIMESTAMP)
  private Date end;

  @Column(name = "DATE_RESERVATION")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "en", timezone = "GMT")
  @Temporal(TemporalType.DATE)
  private Date dateReservation;

  @Column(name = "TITLE")
  private String title;

  @Column(name = "ROOM_ID")
  private String roomId;

  @Column(name = "ROOM_NAME")
  private String roomName;

  @Column(name = "RESERVATION_TYPE")
  private String reservationType;

  @Column(name = "DIVISION_NAME")
  private String divisionName;

  @Column(name = "DESCRIPTION")
  private String description;

  @Column(name = "EMPLOYEE_ID")
  private Integer employeeId;

  @Column(name = "FIRSTNAME_EN")
  private String firstName_En;

  @Column(name = "LASTNAME_EN")
  private String lastName_En;

  @Column(name = "COLOR")
  private String color;

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

  public String getRoomId() {
    return roomId;
  }

  public void setRoomId(String roomId) {
    this.roomId = roomId;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public Integer getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Integer employeeId) {
    this.employeeId = employeeId;
  }

  public String getFirstName_En() {
    return firstName_En;
  }

  public void setFirstName_En(String firstName_En) {
    this.firstName_En = firstName_En;
  }

  public String getLastName_En() {
    return lastName_En;
  }

  public void setLastName_En(String lastName_En) {
    this.lastName_En = lastName_En;
  }

}