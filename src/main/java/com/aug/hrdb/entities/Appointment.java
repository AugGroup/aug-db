package com.aug.hrdb.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="APPOINTMENT")
public class Appointment {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer id;

	@Column(name = "TOPIC")
	private String topic;
	
	@Column(name = "DETAIL")
	private String detail;
	
	@Column(name = "START")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Bangkok")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss",iso = DateTimeFormat.ISO.NONE,style="MM")
	private Date start;
	
	@Column(name = "END")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Bangkok")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss",iso = DateTimeFormat.ISO.NONE,style="MM")
	private Date end;
	
	@Column(name="COLOR",nullable = false)
	private String color;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "APPLICANT_ID", referencedColumnName="ID")
	private Applicant applicant;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "LOGIN_ID", referencedColumnName="ID")
	private Login login;
	
	@Column(name="MAIL_STATUS")
	private Integer mailStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
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

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Integer getMailStatus() {
		return mailStatus;
	}

	public void setMailStatus(Integer mailStatus) {
		this.mailStatus = mailStatus;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", topic=" + topic + ", detail="
				+ detail + ", start=" + start + ", end=" + end + ", applicant="
				+ applicant + ", login=" + login + "]";
	}

}
