package com.aug.hrdb.entities;

import java.util.Date;
import java.util.List;




import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
*
* @author Supannika Pattanodom
*/

@Entity
@Table(name = "AUG_REQUEST")
public class AugRequest extends BaseEntity{

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;

	@Column(name = "C")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy",  locale = "en", timezone = "GMT")
	private Date requestDate;

	@Column(name = "STATUS")
	private String status;

	
	
	@Column(name = "NUMBER_APPLICANT")
	private Integer numberApplicant;

	@Column(name = "SPECIFIC_SKILL")
	private String specificSkill;

	@Column(name = "YEAR_EXPERIENCE")
	private Integer yearExperience;
	
	

	@Column(name = "CODE_REQUEST")
	private String codeRequest ;
	
	
	
	@ManyToOne
	@JoinColumn(name = "MASTECHNOLOGY_ID", referencedColumnName = "id", nullable = false)
	private MasTechnology technology;

	@ManyToOne
	@JoinColumn(name = "MASJOBLEVEL_ID", referencedColumnName = "id", nullable = false)
	private MasJoblevel joblevel;
	
	

	
	@JsonIgnore
	@OneToMany(mappedBy = "augRequest",cascade=CascadeType.REMOVE)
	private List<Applicant> applicants;
	
	
	public List<Applicant> getApplicants() {
		return applicants;
	}

	public void setApplicants(List<Applicant> applicants) {
		this.applicants = applicants;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getNumberApplicant() {
		return numberApplicant;
	}

	public void setNumberApplicant(Integer numberApplicant) {
		this.numberApplicant = numberApplicant;
	}

	public String getSpecificSkill() {
		return specificSkill;
	}

	public void setSpecificSkill(String specificSkill) {
		this.specificSkill = specificSkill;
	}

	public Integer getYearExperience() {
		return yearExperience;
	}

	public void setYearExperience(Integer yearExperience) {
		this.yearExperience = yearExperience;
	}

	public MasTechnology getTechnology() {
		return technology;
	}

	public void setTechnology(MasTechnology technology) {
		this.technology = technology;
	}

	public MasJoblevel getJoblevel() {
		return joblevel;
	}

	public void setJoblevel(MasJoblevel joblevel) {
		this.joblevel = joblevel;
	}

	public String getCodeRequest() {
		return codeRequest;
	}

	public void setCodeRequest(String codeRequest) {
		this.codeRequest = codeRequest;
	}

	


	

}
