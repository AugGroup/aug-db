package com.aug.hrdb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="MAS_RELATIONTYPE")
public class MasRelationType extends BaseEntity{
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer id;
	@Column(name="RELATIONTYPE",nullable=false)
	private String  relationType;
	@Column(name = "CODE", nullable = false, length = 10)
	private String code;
	@Column(name = "ISACTIVE", nullable = false)
	private Boolean isActive;


	
	
	
	public Integer getId() {
		return id;
	}
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	public String getRelationType() {
		return relationType;
	}
	
	
	
	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}



	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}


	
	 


}
