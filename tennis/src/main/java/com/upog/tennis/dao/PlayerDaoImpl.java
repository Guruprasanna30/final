package com.upog.tennis.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upog.tennis.model.Player;
import com.upog.tennis.model.TournamentPlayerDetails;
import com.upog.tennis.repository.PlayerRepository;


@Component
public class PlayerDaoImpl {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	public ArrayList<Player> findPlayerbyTournament(int tournamentId){
		return playerRepository.findPlayerbyTournament( tournamentId);
		}
	
	
	public Player findPlayerById(int playerId) {
		return playerRepository.findById(playerId);
	}
	public List<Player> findPlayerByName(String  name) {
		return playerRepository.findPlayerByName(name);
	}
	
	public Player findPlayerByUserName(String  userName) {
		return playerRepository.findByUserName(userName);
	}
}
