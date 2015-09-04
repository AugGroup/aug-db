package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.dto.ProbationDto;
import com.aug.hrdb.entities.Probation;
import com.aug.hrdb.repositories.ProbationRepository;

@Repository
public class ProbationRepositoryImpl extends GenericRepositoryImpl<Probation, Integer> implements ProbationRepository{

	public ProbationRepositoryImpl() {
		super(Probation.class);
	}
	
	@Override
	public void deleteById(Integer id){
		
		Probation probation =(Probation)getCurrentSession().load(Probation.class, id);
		if(probation != null){
			getCurrentSession().delete(probation);
		}
	}

	@Override
	public List<Probation> findByCriteria(Probation probation) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProbationDto> searchProbation(Integer id){
		Query namedQuery = getCurrentSession().getNamedQuery("searchProbation").setInteger("empId" ,id);
		//namedQuery.executeUpdate();
		List<ProbationDto> expDto = namedQuery.list();
	     return expDto;
	}
	
	@SuppressWarnings("unchecked")
	public void createProbation(ProbationDto probationDto){
		Query namedQuery = getCurrentSession().getNamedQuery("createProbation");
	}

}
