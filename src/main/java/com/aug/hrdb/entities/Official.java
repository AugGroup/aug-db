/**
 *
 * @author natechanok
 * @date Apr 30, 2015
 */

package com.aug.hrdb.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

import com.fasterxml.jackson.annotation.JsonFormat;



@NamedNativeQueries({
	@NamedNativeQuery(
            name = "insertOfficial",
            query = "insert into OFFICIAL("
            		+ "OFFICIAL_DATE,"
            		+ "START_WORK_DATE,"
            		+ "END_WORK_DATE,"
            		+ "POSITION_APPLIED_FOR,"
            		+ "SALARY_EXPECTED,"
            		+ "PROBATION_DATE,"
            		+ "createdTimeStamp,"
            		+ "createdBy,"
            		+ "auditFlag"
            		//+ "EMPLOYEE_ID"
            		+ ") "
            		+ " values("
            		+ ":OFFICIAL_DATE,"
            		+ ":START_WORK_DATE,"
            		+ ":END_WORK_DATE,"
            		+ ":POSITION_APPLIED_FOR,"
            		+ ":SALARY_EXPECTED,"
            		+ ":PROBATION_DATE,"
            		+ "NOW(),"
            		+ "0,"
            		+ "'C'"
            		//+ ":EMPLOYEE_ID"
            		+ ")"
            	
            		,resultClass= Official.class),
            		
           @NamedNativeQuery(
		           name = "searchIdEmptoOfficial",
		           query = "select * from OFFICIAL ORDER BY ID desc LIMIT 1;", 
		           resultClass = Official.class),
            
            @NamedNativeQuery(
                    name = "updateOfficial",
                    query = "update OFFICIAL set OFFICIAL_DATE =:OFFICIAL_DATE,"
                       		+ "START_WORK_DATE =:START_WORK_DATE, "
                       		+ "END_WORK_DATE =:END_WORK_DATE, "
                       		+ "POSITION_APPLIED_FOR =:POSITION_APPLIED_FOR, "
                       		+ "SALARY_EXPECTED =:SALARY_EXPECTED, "
                       		+ "PROBATION_DATE =:PROBATION_DATE, "
                       		+ "updatedTimeStamp = NOW(), "
                       		+ "updatedBy =:updatedBy,"
                       		+ "auditFlag ='U' where ID =:ID", 
                        resultClass = Official.class),
                        
             @NamedNativeQuery(
                      name = "deleteOfficial",
                      query = "delete from EMP_OFFICIAL where ID=:id", 
                      resultClass = Official.class),    
  })

@Entity
@Table(name = "OFFICIAL",uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Official extends BaseEntity{
		@Id
	    @GeneratedValue
	    @Column(name = "ID")
	    private Integer id;
		
		/*@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-mm-yyyy")
		@Column(name = "OFFICIAL_DATE")
		//@Temporal(TemporalType.TIMESTAMP)
		private Date officialDate;*/
		
		@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-mm-yyyy")
		@Column(name = "START_WORK_DATE")
		//@Temporal(TemporalType.TIMESTAMP)
		private Date startWorkDate;
		
		@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-mm-yyyy")
		@Column(name = "END_WORK_DATE")
		//@Temporal(TemporalType.TIMESTAMP)
		private Date endWorkDate;

	 	/*@Column(name = "POSITION_APPLIED_FOR", nullable = false)
		private String positionAppliedFor;
		
		@Column(name = "SALARY_EXPECTED", nullable = false)
		private String salaryExpected;*/
		
		@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-mm-yyyy")
		@Column(name = "PROBATION_DATE")
		//@Temporal(TemporalType.TIMESTAMP)
		private Date probationDate;
	    
		 @OneToOne(fetch=FetchType.LAZY,mappedBy="official")
		 private Applicant applicant;


//	------------------------------------------- getter setter ---------------------------------------------//
		 
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		/*public Date getOfficialDate() {
			return officialDate;
		}

		public void setOfficialDate(Date officialDate) {
			this.officialDate = officialDate;
		}*/

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

		/*public String getPositionAppliedFor() {
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
		}*/


		public Date getProbationDate() {
			return probationDate;
		}

		public Applicant getApplicant() {
			return applicant;
		}

		public void setApplicant(Applicant applicant) {
			this.applicant = applicant;
		}

		public void setProbationDate(Date probationDate) {
			this.probationDate = probationDate;
		}


}
