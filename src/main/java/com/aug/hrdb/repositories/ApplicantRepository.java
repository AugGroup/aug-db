package com.aug.hrdb.repositories;

import java.io.Serializable;
import java.util.List;

import com.aug.hrdb.dto.ApplicantDto;
import com.aug.hrdb.dto.JoblevelDto;
import com.aug.hrdb.dto.ReportApplicantDto;
import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.MasJobLevel;

public interface ApplicantRepository extends GenericRepository<Applicant, Serializable> {
	
	List<ApplicantDto> findByJoblevel(String joblevel);
	List<ApplicantDto> findAllApplicant();
	ApplicantDto findApplicantById(Integer id);
	ApplicantDto findApplicationById(Integer id);
	List<ApplicantDto> findByTrackingStatus(String trackingStatus);
	List<JoblevelDto> checkTag(String tag);
	/*-------------------- report --------------------*/
	List<ReportApplicantDto> reportApplicant();
	List<ReportApplicantDto> findReportByCriteria(Integer technology,Integer joblevel, Integer masdegreetype, String major, String university, Double gpa);
	/*-------------------- Monthly report --------------------*/
	List<ReportApplicantDto> findReportByMonth(String startDate,String endDate);
	void update(ApplicantDto applicantDto);
	ApplicantDto getMaxApplicantId();

}
