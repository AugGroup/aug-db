package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.dto.AugRequestDto;
import com.aug.hrdb.entities.AugRequest;

/**
*
* @author Supannika Pattanodom
*/
public interface AugRequestService {

   public void create (AugRequest augRequest);
   
   public AugRequest findById (Integer id);
   
   public void update (AugRequest augRequest);
   
   public void delete (AugRequest augRequest);
   
   public void deleteById(Integer id);
   
   public List<AugRequest> findAll();
   
   public List<AugRequestDto> findAllAugRequest();
   
   public AugRequestDto findAugRequestById(Integer id);
   
   /*---------------For Test SQLGrammaException---------------*/
   public AugRequestDto findAugRequestByIdTest(Integer id);
   
   public List<AugRequestDto> getJobcaseCode();
   
}

