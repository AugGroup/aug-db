/**
 *
 * @author Pranrajit
 * @date 27 ต.ค. 2558
 */
package com.aug.hrdb.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="ROOM")
public class Room extends BaseEntity{
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;
	
	@Column(name="NAME",nullable = false)
	private String name;
	
	@Column(name="CAPACITY",nullable = false)
	private Integer capacity;
	
	@Column(name="DESCRIPTION",nullable = false)
	private String description;
	
	@OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade=CascadeType.REMOVE)
    @JsonIgnore
    private Set<Reservation> reservation = new HashSet<Reservation>();
	
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

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(Set<Reservation> reservation) {
		this.reservation = reservation;
	}
	
}
