package com.aug.hrdb.repositories;

import java.io.Serializable;
import java.util.List;

import com.aug.hrdb.dto.ApplicantDto;
import com.aug.hrdb.dto.JoblevelDto;
import com.aug.hrdb.dto.ReportApplicantDto;
import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.MasJobLevel;

public interface ApplicantRepository extends GenericRepository<Applicant, Serializable> {

//	public List<ApplicantDto> findByTechnology(String technology);
	
	public List<ApplicantDto> findByJoblevel(String joblevel);
	
	public List<ApplicantDto> findAllApplicant();
	
	public ApplicantDto findApplicantById(Integer id);
	
	public ApplicantDto findApplicationById(Integer id);
	
	public List<ApplicantDto> findByTrackingStatus(String trackingStatus);
	
	public List<JoblevelDto> checkTag(String tag);

	/*-------------------- report --------------------*/
	public List<ReportApplicantDto> reportApplicant();
	
	public List<ReportApplicantDto> findReportByCriteria(Integer technology,Integer joblevel, Integer masdegreetype, String major, String university, Double gpa);

	/*-------------------- Monthly report --------------------*/
	public List<ReportApplicantDto> findReportByMonth(String startDate,String endDate);	
	public void update(ApplicantDto applicantDto);
	
	public ApplicantDto getMaxApplicantId();

	

}
