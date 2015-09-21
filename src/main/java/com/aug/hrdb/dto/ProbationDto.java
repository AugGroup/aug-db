package com.aug.hrdb.dto;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@NamedNativeQueries({
    @NamedNativeQuery(
            name = "searchProbation",
            query = "select pro.id, "
            		+ "pro.date_from, "
            		+ "pro.date_to, "
            		+ "pro.status,"
            		+ "pro.reason,"
            		+ "pro.employee_id, "
            		+ "emp.employee_code "
            		+ "from emp_probation as pro, employee as emp "
            		+ "where pro.employee_id=:empId and emp.id = pro.employee_id",
            resultClass = ProbationDto.class),
//    @NamedNativeQuery(name = "createProbation", 
//    		query = "insert into emp_probation as pro (pro.date_from, pro.date_to, pro.status,pro.employee_id) values (?dateFrom, ?dateTo, ?status, ?employeeId)",
//    		resultClass = Probation.class)
})
@Entity
public class ProbationDto {
	
	   	@Id
	    private Integer id;
	    private Date dateFrom;
	    private Date dateTo;
	    private String status;
	    private String reason;
	    private Integer employeeId;
	    private String employeeCode;

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public Date getDateFrom() {
	        return dateFrom;
	    }

	    public void setDateFrom(Date dateFrom) {
	        this.dateFrom = dateFrom;
	    }

	    public Date getDateTo() {
	        return dateTo;
	    }

	    public void setDateTo(Date dateTo) {
	        this.dateTo = dateTo;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public String getEmployeeCode() {
	        return employeeCode;
	    }

	    public void setEmployeeCode(String employeeCode) {
	        this.employeeCode = employeeCode;
	    }

	    public Integer getEmployeeId() {
	        return employeeId;
	    }

	    public void setEmployeeId(Integer employeeId) {
	        this.employeeId = employeeId;
	    }

		public String getReason() {
			return reason;
		}

		public void setReason(String reason) {
			this.reason = reason;
		}

}
