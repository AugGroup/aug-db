package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.dto.ApplicantDto;
import com.aug.hrdb.dto.JoblevelDto;
import com.aug.hrdb.dto.ReportApplicantDto;
import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.MasJobLevel;

public interface ApplicantService {
	public void create(Applicant applicant);

	public Applicant findById(Integer id);

	public List<Applicant> findAll();
	
//	public List<ApplicantDto> findByTechnology(String technology);
	
	public List<ApplicantDto> findByJoblevel(String joblevel);
	
	public ApplicantDto findApplicantById(Integer id);
	
	public List<ApplicantDto> findAllApplicant();

	public void update(Applicant applicant);

	public void delete(Applicant applicant);

	public void deleteById(Integer id);
	
	public ApplicantDto saveInformations(ApplicantDto applicantDto);

	public ApplicantDto findByIdApplicant(Integer id);
	
	public ApplicantDto findApplicationById(Integer id);
	
	public List<ApplicantDto> findByTrackingStatus(String trackingStatus);
	
	public List<JoblevelDto> checkTag(String tag);
	
	/*-------------------- report search --------------------*/
	public List<ReportApplicantDto> reportApplicant();
	
	public List<ReportApplicantDto> findReportByCriteria(Integer technology,Integer joblevel, Integer masdegreetype, String major, String university, Double gpa);

	/*-------------------- Monthly report --------------------*/
	public List<ReportApplicantDto> findReportByMonth(String startDate,String endDate);
	
	public void update(ApplicantDto applicantDto);

	public ApplicantDto getMaxApplicantId();

	
}
