package com.aug.hrdb.entities;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;
/**
 * @author Thanyalak
 *
 */
/**
 * @author Thanyalak
 *
 */
/**
 * @author Thanyalak
 *
 */
@NamedNativeQueries({            		
@NamedNativeQuery(
           name = "searchIdEmptoLogin",
           query = "select * from EMP_LOGIN ORDER BY ID desc LIMIT 1;", 
            resultClass = Login.class)
  })


@Entity
@Table(name="LOGIN" ,uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Login extends BaseEntity{

	@Id
	@GeneratedValue
	@Column(name="ID")	
	private Integer id;
	@Column(name="USERNAME",nullable=false)
	private String username;
	@Column(name="PASSWORD",length=13,nullable=false)
	private String password;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "EMPLOYEE_ID",nullable = false)
	private Employee employee;

	
	@ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)	
	@JoinTable(name="LOGINROLE", joinColumns={ @JoinColumn(name="LOGIN_ID" , referencedColumnName="ID")},
		inverseJoinColumns={ @JoinColumn(name="MASROLE_ID" , referencedColumnName="ID")})	
    private Set<MasRole> masRoles = new HashSet<MasRole>();  

	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name= "MAS_LOCATION_ID")
    private MasLocation masLocation;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Set<MasRole> getMasRoles() {
		return masRoles;
	}


	public void setMasRoles(Set<MasRole> masRoles) {
		this.masRoles = masRoles;
	}


	public MasLocation getMasLocation() {
		return masLocation;
	}


	public void setMasLocation(MasLocation masLocation) {
		this.masLocation = masLocation;
	}
    


		
}
