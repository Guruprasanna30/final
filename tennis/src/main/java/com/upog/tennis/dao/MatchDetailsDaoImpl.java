package com.upog.tennis.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upog.tennis.model.MatchDetails;
import com.upog.tennis.repository.MatchDetailsRepository;


@Component
public class MatchDetailsDaoImpl {
	
	@Autowired
	private MatchDetailsRepository matchDetailsRepository;
	
	public void createMatch(MatchDetails matchDetails) {
		matchDetailsRepository.save(matchDetails);
	}
	
	public void createMatchList(List<MatchDetails> matchDetails) {
		matchDetailsRepository.saveAll(matchDetails);
	}
	
	
	public List<MatchDetails>findMatchDetailsbyTournament(int tournamentId){
		return matchDetailsRepository.findByTournament_Id(tournamentId);
	}
}
