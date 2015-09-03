/**
 *
 * @author natechanok
 * @date May 28, 2015
 */

package com.aug.hrdb.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;




@Component
//@Entity
public class OfficialDto {
	
	 //@Column(name = "ID")
	    private Integer id;
		
	    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-mm-yyyy")
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date officialDate;
	    
	    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-mm-yyyy")
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date startWorkDate;
	    
	    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-mm-yyyy")
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date endWorkDate;

	 //@Column(name = "POSITION_APPLIED_FOR", nullable = true)
		private String positionAppliedFor;
		
	//@Column(name = "SALARY_EXPECTED", nullable = true)
		private String salaryExpected;
		
		@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-mm-yyyy")
		@Temporal(TemporalType.TIMESTAMP)
		private Date probationDate;
	    
		private Integer employeeId;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Date getOfficialDate() {
			return officialDate;
		}

		public void setOfficialDate(Date officialDate) {
			this.officialDate = officialDate;
		}

		public Date getStartWorkDate() {
			return startWorkDate;
		}

		public void setStartWorkDate(Date startWorkDate) {
			this.startWorkDate = startWorkDate;
		}

		public Date getEndWorkDate() {
			return endWorkDate;
		}

		public void setEndWorkDate(Date endWorkDate) {
			this.endWorkDate = endWorkDate;
		}

		public String getPositionAppliedFor() {
			return positionAppliedFor;
		}

		public void setPositionAppliedFor(String positionAppliedFor) {
			this.positionAppliedFor = positionAppliedFor;
		}

		public String getSalaryExpected() {
			return salaryExpected;
		}

		public void setSalaryExpected(String salaryExpected) {
			this.salaryExpected = salaryExpected;
		}

		public Integer getEmployeeId() {
			return employeeId;
		}

		public void setEmployeeId(Integer employeeId) {
			this.employeeId = employeeId;
		}

		public Date getProbationDate() {
			return probationDate;
		}

		public void setProbationDate(Date probationDate) {
			this.probationDate = probationDate;
		}
		


}
