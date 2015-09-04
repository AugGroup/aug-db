/**
 *
 * @author Pranrajit
 * @date 20 เม.ย. 2558
 */
package com.aug.hrdb.entities;


import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;





@Entity
@Table(name="ABILITY")
public class Ability extends BaseEntity  {
	

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;


	@Column(name = "RANK",nullable = false)
	private Integer rank;
	
	
	
	/*@ManyToOne(fetch=FetchType.EAGER)
	 @JoinColumn(name="OFFICIAL_ID" , referencedColumnName="id")
	 private Official official;*/
	

	/*@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "EMPLOYEE_ID",nullable = false,referencedColumnName="id")
	private Employee employee;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "SPECIALTY_ID",nullable = false,referencedColumnName="SPEC_ID")
//	@JsonIgnore
	private MasSpecialty masspecialty;*/

	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	
	public Integer getRank() {
		return rank;
	}
	
	public void setRank(Integer rank) {
		this.rank = rank;
	}



/*	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
	public MasSpecialty getMasspecialty() {
		return masspecialty;
	}

	public void setMasspecialty(MasSpecialty masspecialty) {
		this.masspecialty = masspecialty;
	}

	
 
	
	public AbilityDto toAbilityDto(){
		AbilityDto abilityDto = new AbilityDto();
		abilityDto.setId(this.id);
		abilityDto.setRank(this.rank);
		abilityDto.setEmployeeCode(this.employee.getEmployeeCode());
		abilityDto.setEmployeeId(this.employee.getId());
		abilityDto.setMasspecialtyId(this.masspecialty.getId());
		abilityDto.setMasspecialty(this.masspecialty.getName());;
		return abilityDto;
		
	}
	
	public Ability fromAbilityDto (AbilityDto abilityDto,Ability ability){
		//Ability ability = new Ability();
		//ability.setId(abilityDto.getId());
		ability.setRank(abilityDto.getRank());
		
		MasSpecialty masspecialty=new MasSpecialty();
		masspecialty.setId(abilityDto.getMasspecialtyId());
		masspecialty.setName(abilityDto.getMasspecialty());
		ability.setMasspecialty(masspecialty);
		
		Employee employee = new Employee();
		employee.setId(abilityDto.getEmployeeId());
		ability.setEmployee(employee);
		return ability;
		
	}
	*/
}
