package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.dto.CardDto;
import com.aug.hrdb.entities.Card;

public interface CardService {
	
	void create(Card card);
	void update(Card card);
	void delete(Card card);
	Card findById(Integer id);
	List<Card> findAll();
	List<Card> findByCriteria(Card card);
	void deleteById(Integer id);
	List<CardDto> searchCard(Integer id);

}
