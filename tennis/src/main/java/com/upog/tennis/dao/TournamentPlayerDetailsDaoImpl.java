package com.upog.tennis.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upog.tennis.model.TournamentPlayerDetails;
import com.upog.tennis.repository.TournamentPlayerDetailsRepository;


@Component
public class TournamentPlayerDetailsDaoImpl {
	
	@Autowired
	private TournamentPlayerDetailsRepository tournamentPlayerDetailsRepository;
	
	public List<TournamentPlayerDetails> findTournamentPlayerDetails(int tournamentId){
	return tournamentPlayerDetailsRepository.findByTournament_Id( tournamentId);
	}
	
}
