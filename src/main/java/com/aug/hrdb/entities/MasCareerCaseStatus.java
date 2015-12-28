package com.aug.hrdb.entities;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="MAS_CAREER_CASE_STATUS")
public class MasCareerCaseStatus extends BaseEntity {
	
	@Id @GeneratedValue @Column(name="ID")
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy="masCareerCaseStatus", fetch = FetchType.LAZY)
	private List<CareerCase> careerCases;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CareerCase> getCareerCases() {
		return careerCases;
	}

	public void setCareerCases(List<CareerCase> careerCases) {
		this.careerCases = careerCases;
	}

}
