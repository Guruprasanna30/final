package com.upog.tennis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.upog.tennis.repository.SexRepository;


@Component
public class SexDaoImpl {
	
	@Autowired
	private SexRepository sexRepository;
	
}
