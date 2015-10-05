package com.aug.hrdb.repositories.impl;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

import javax.mail.Session;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.ApplicantDto;
import com.aug.hrdb.dto.ReportApplicantDto;
import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.repositories.ApplicantRepository;

@Repository(value = "applicantRepository")
@Transactional
public class ApplicantRepositoryImpl extends GenericRepositoryImpl<Applicant, Serializable> implements ApplicantRepository {
	public ApplicantRepositoryImpl() {
		super(Applicant.class);
	}

//	@Override
//	public List<ApplicantDto> findByTechnology(String technology) {
//		Query query = getCurrentSession().getNamedQuery("SEARCH_APPLICANT");
//		query.setParameter("TECHNOLOGY", "%" + technology + "%");
//		List<ApplicantDto> results = query.list();
//		return results;
//	}
	
	@Override
	public List<ApplicantDto> findByJoblevel(String joblevel) {
		Query query = getCurrentSession().getNamedQuery("SEARCH_APPLICANT");
		query.setParameter("JOBLEVEL", "%" + joblevel + "%");
		List<ApplicantDto> results = query.list();
		return results;
	}
	@Override
	public List<ApplicantDto> findAllApplicant() {
		Query query = getCurrentSession().getNamedQuery("SEARCH_ALL");
		List<ApplicantDto> results = query.list();
		return results;
	}

	@Override
	public ApplicantDto findApplicantById(Integer id) {
		Query query = getCurrentSession().getNamedQuery("SEARCH_BY_ID");
		query.setParameter("ID", id);
		List<ApplicantDto> result = query.list();
		ApplicantDto app = result.get(0);
		return app;
	}
	
	@Override
	public List<ApplicantDto> findByTrackingStatus(String trackingStatus) {
		Query query = getCurrentSession().getNamedQuery("SEARCH_BY_TRACKINGSTATUS");
		query.setParameter("TRACKING_STATUS",trackingStatus);
		List<ApplicantDto> applicants = query.list();
		return applicants;
	}
	
/*-------------------- report --------------------*/
	@Override
	public List<ReportApplicantDto> reportApplicant() {
		Query query = getCurrentSession().getNamedQuery("REPORT_APPLICANT");
		List<ReportApplicantDto> results = query.list();
		return results;
	}

	@Override
	public List<ReportApplicantDto> findReportByCriteria(Integer technology,Integer joblevel, Integer masdegreetype, String major, String university, Double gpa) {
		Query query = getCurrentSession().getNamedQuery("REPORT_SEARCH_BY_CRITERIA");
		String queryStr = query.getQueryString();
		if (technology > 0) {
			queryStr = query.getQueryString();
			queryStr += " AND technology.ID = :TECHNOLOGY ";
			query = getCurrentSession().createSQLQuery(queryStr).addEntity(ReportApplicantDto.class);
			query.setParameter("TECHNOLOGY", technology);
		}
		if (joblevel > 0) {
			queryStr = query.getQueryString();
			queryStr += " AND joblevel.ID = :JOBLEVEL ";
			query = getCurrentSession().createSQLQuery(queryStr).addEntity(ReportApplicantDto.class);
			query.setParameter("JOBLEVEL", joblevel);
		}
		if (masdegreetype > 0) {
			queryStr = query.getQueryString();
			queryStr += " AND degreeType.ID = :DEGREE";
			query = getCurrentSession().createSQLQuery(queryStr).addEntity(ReportApplicantDto.class);
			query.setParameter("DEGREE", masdegreetype);
		}
		if (gpa != null) {
			queryStr = query.getQueryString();
			queryStr += " AND education.GPA = :GPA";
			query = getCurrentSession().createSQLQuery(queryStr).addEntity(ReportApplicantDto.class);
			query.setParameter("GPA", gpa);
		}
		query = getCurrentSession().createSQLQuery(queryStr).addEntity(ReportApplicantDto.class);
		if (technology > 0) {
			query.setParameter("TECHNOLOGY", technology);
		}
		if (joblevel > 0) {
			query.setParameter("JOBLEVEL", joblevel);
		}
		if (masdegreetype > 0) {
			query.setParameter("DEGREE", masdegreetype);
		}
		if (gpa != null) {
			query.setParameter("GPA", gpa);
			System.out.println("TEST:::" + queryStr);
		}
		
		query.setParameter("MAJOR", "%" + major + "%");
		query.setParameter("UNIVERSITY", "%"+ university +"%");
		
		List<ReportApplicantDto> results = query.list();
		//System.out.println("queryStr :"+ queryStr);
		return results;
	}
	
	
	/*-------------------- Monthly report --------------------*/
	public List<ReportApplicantDto> findReportByMonth(String startDate,String endDate){
		Query query = getCurrentSession().getNamedQuery("REPORT_SEARCH_BY_MONTH"); 
		
			query.setParameter("STARTDATE", startDate);
			query.setParameter("ENDDATE", endDate);

			
			System.out.println("STARTDATE "+startDate+" ENDDATE "+endDate);
		//}
		List<ReportApplicantDto> results = query.list();
		return results;
	}
	
	@Override
	public ApplicantDto findApplicationById(Integer id) {
		Query query = getCurrentSession().getNamedQuery("SEARCH_BY_ID_APPLICATION");
		query.setParameter("ID", id);
		List<ApplicantDto> result = query.list();
		ApplicantDto app = result.get(0);
		return app;
	}

	@Override
	public void update(ApplicantDto applicantDto) {
		Applicant applicant= new Applicant();
		try {
			getCurrentSession().saveOrUpdate(applicant.fromApplicantDTO(applicant, applicantDto));
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ApplicantDto getMaxApplicantId() {
		Query query = getCurrentSession().getNamedQuery("MAX_ID_APPLICANT");
		List<ApplicantDto> result = query.list();
		ApplicantDto app = result.get(0);
		return app;
	}

	


	
	

}
