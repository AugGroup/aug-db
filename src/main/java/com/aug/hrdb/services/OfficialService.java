/**
 * @author natechanok
 * @date Apr 30, 2015
 */
package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.dto.OfficialDto;
import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Official;

public interface OfficialService {

  void create(Official official);

  void update(Official official);

  void delete(Official official);

  Official findById(Integer id);

  void deleteById(Integer id);

  List<Official> findAll();


  List<Official> findByCriteria(Applicant applicant);

  void saveOfficialByNameQuery(OfficialDto officialDto);

  void updateOfficialByNameQuery(OfficialDto officialDto);

  Official searchEmpIdToOfficial();

}