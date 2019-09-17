package com.upog.tennis.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.upog.tennis.dao.ReportsDaoImpl;
import com.upog.tennis.dao.TournamentDaoImpl;
import com.upog.tennis.exception.ResponeException;
import com.upog.tennis.model.MatchDetails;
import com.upog.tennis.model.Tournament;
import com.upog.tennis.repository.TournamentRepository;
import com.upog.tennis.util.Constant;
import com.upog.tennis.util.Util; 

@Component
public class TournamentService {
	
	@Autowired
	TournamentDaoImpl tournamentDaoImpl;


	public List<MatchDetails> generateTournamentSchedule(int tournamentId) throws ResponeException{
		List<MatchDetails> tournamentSchedule =null;
		try {
			Tournament tournament = tournamentDaoImpl.findById(tournamentId);
			Util.generateTournamentSchedule(tournament);
			System.out.println(tournament);
			return tournamentSchedule;
			}catch (Exception e) {
				throw new ResponeException(e);
			}
	}
	
	
}
