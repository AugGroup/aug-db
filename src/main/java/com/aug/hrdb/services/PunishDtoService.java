package com.aug.hrdb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.PunishDto;
import com.aug.hrdb.repositories.PunishRepository;


@Service("punishDtoService")
@Transactional
public class PunishDtoService {
		
	@Autowired private PunishRepository punishRepository;
	
	public List<PunishDto> searchPunish(Integer id){
		return punishRepository.searchPunish(id);
	}
}
