package com.aug.hrdb.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="CLIENT")
public class Client extends BaseEntity {

	@Id @GeneratedValue @Column(name="ID")
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy="client")
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
