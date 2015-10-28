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

import com.fasterxml.jackson.annotation.JsonFormat;

@NamedNativeQueries({
	@NamedNativeQuery(name="GET_RESERVATIONS",
			query = "SELECT ID,START_TIME,END_TIME,DESCRIPTION as TITLE FROM RESERVATION r WHERE DATE(r.`START_TIME`) >= STR_TO_DATE(:START,'%Y-%m-%d') AND  DATE(r.`END_TIME`) <= STR_TO_DATE(:END,'%Y-%m-%d')",
					resultClass = ReservationDto.class)
	
})
@Entity
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
	
	@Column(name="TITLE")
	private String title;

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
	
	
}
