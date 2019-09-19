package com.upog.tennis.repository;

import org.springframework.stereotype.Repository;


import com.upog.tennis.model.TournamentPlayerDetails;
import com.upog.tennis.model.Tournament;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TournamentPlayerDetailsRepository extends JpaRepository<TournamentPlayerDetails, Integer>{
	
	public List<TournamentPlayerDetails> findByTournament_Id(int tournamentId); 


}
