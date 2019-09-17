package com.upog.tennis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upog.tennis.model.Tournament;
import com.upog.tennis.repository.TournamentRepository;


@Component
public class TournamentDaoImpl {
	
	@Autowired
	private TournamentRepository tournamentRepository;
	
	public Tournament findById( int tournamentId){
		return tournamentRepository.findById(tournamentId);
		
	}

	
}
