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

import com.aug.hrdb.dto.AbilityDto;

@Entity
@Table(name="ABILITY")
public class Ability extends BaseEntity  {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;

	@Column(name = "RANK",nullable = false)
	private Integer rank;

	@ManyToOne
	@JoinColumn(name="APPLICANT_ID")
	private Applicant applicant;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "SPECIALTY_ID",nullable = false,referencedColumnName="ID")
	private MasSpecialty masspecialty;

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
	
	public MasSpecialty getMasspecialty() {
		return masspecialty;
	}

	public void setMasspecialty(MasSpecialty masspecialty) {
		this.masspecialty = masspecialty;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public AbilityDto toAbilityDto(){

		AbilityDto abilityDto = new AbilityDto();
		abilityDto.setId(this.id);
		abilityDto.setRank(this.rank);
		abilityDto.setApplicantId(this.applicant.getId());
		abilityDto.setMasspecialtyId(this.masspecialty.getId());
		abilityDto.setMasspecialty(this.masspecialty.getName());;

		return abilityDto;
		
	}
	
	public Ability fromAbilityDto (AbilityDto abilityDto,Ability ability){

		ability.setRank(abilityDto.getRank());

		Applicant applicant = new Applicant();
		applicant.setId(abilityDto.getId());
		ability.setApplicant(applicant);

		MasSpecialty masspecialty=new MasSpecialty();
		masspecialty.setId(abilityDto.getMasspecialtyId());
		masspecialty.setName(abilityDto.getMasspecialty());
		ability.setMasspecialty(masspecialty);

		return ability;
		
	}
	
}