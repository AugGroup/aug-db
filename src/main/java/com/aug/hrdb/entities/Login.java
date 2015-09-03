package com.aug.hrdb.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;
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
//	@OneToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name = "EMPLOYEE_ID",nullable = false)
//	private Employee employee;
	
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name= "ROLE_ID")
    private MasRole masRole;  
    
    
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


	public MasRole getMasRole() {
		return masRole;
	}


	public void setMasRole(MasRole masRole) {
		this.masRole = masRole;
	}


	public MasLocation getMasLocation() {
	   return masLocation;
	}


    public void setMasLocation(MasLocation masLocation) {
		this.masLocation = masLocation;
    }
	
	

//	public Employee getEmployee() {
//		return employee;
//	}
//
//
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}

		
}
