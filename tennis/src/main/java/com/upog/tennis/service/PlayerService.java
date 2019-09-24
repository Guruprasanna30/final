package com.upog.tennis.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upog.tennis.dao.PlayerDaoImpl;
import com.upog.tennis.dao.ReportsDaoImpl;
import com.upog.tennis.exception.ResponeException;
import com.upog.tennis.model.MatchDetails;
import com.upog.tennis.model.Player;
import com.upog.tennis.util.Constant;
import com.upog.tennis.util.Util; 

@Component
public class PlayerService {
	
	

	@Autowired
	PlayerDaoImpl playerDaoImpl;
	

	public Player findPlayerById(int playerId) throws ResponeException{
		try {
		Player player= playerDaoImpl.findPlayerById(playerId);
		if(player==null) {throw new ResponeException("Player Not Found");}
		
		return player;	
		}catch (Exception e) {
			throw new ResponeException(e);
		}
	}
		
		public Player findPlayerByUserName(String userName) throws ResponeException{ 
			try {
			Player player= playerDaoImpl.findPlayerByUserName(userName);
			if(player==null) {throw new ResponeException("Player Not Found");}
			
			return player;	
			}catch (Exception e) {
				throw new ResponeException(e);
			}
	}
		
		public List<Player> findPlayerName(String name) throws ResponeException{ 
			try {
			List<Player> playerList= playerDaoImpl.findPlayerByName("%"+name+"%");
			if(playerList==null) {throw new ResponeException("Player Not Found");}
			
			return playerList;	
			}catch (Exception e) {
				throw new ResponeException(e);
			}
	}
	

	
	
}
