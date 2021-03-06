package com.upog.tennis.repository;

import org.springframework.stereotype.Repository;

import com.upog.tennis.model.MatchDetails;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MatchDetailsRepository extends JpaRepository<MatchDetails, Integer>{
	
	
	public List<MatchDetails> findByTournament_Id(int tournamentId); 

	

}
