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

import com.upog.tennis.dao.MatchDetailsDaoImpl;
import com.upog.tennis.dao.MediaDaoImpl;
import com.upog.tennis.dao.PlayerDaoImpl;
import com.upog.tennis.dao.ReportsDaoImpl;
import com.upog.tennis.dao.TournamentDaoImpl;
import com.upog.tennis.dao.TournamentPlayerDetailsDaoImpl;
import com.upog.tennis.exception.ResponeException;
import com.upog.tennis.model.MatchDetails;
import com.upog.tennis.model.Media;
import com.upog.tennis.model.Player;
import com.upog.tennis.model.Tournament;
import com.upog.tennis.model.TournamentPlayerDetails;
import com.upog.tennis.repository.TournamentRepository;
import com.upog.tennis.util.Constant;
import com.upog.tennis.util.Util; 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class TournamentService {
	
	@Autowired
	TournamentDaoImpl tournamentDaoImpl;
	
	@Autowired
	TournamentPlayerDetailsDaoImpl tournamentPlayerDetailsDaoImpl;
	
	@Autowired
	PlayerDaoImpl playerDaoImpl;
	
	@Autowired
	MediaDaoImpl mediaDaoImpl;
	
	@Autowired
	TennisService tennisService;
	
	@Autowired
	MatchDetailsDaoImpl matchDetailsDaoImpl;

	  private static final Logger logger = LoggerFactory.getLogger(TournamentService.class);
	  
	public List<MatchDetails> generateTournamentSchedule(int tournamentId) throws ResponeException{
		List<MatchDetails> tournamentMatchList =null;
		try {
			Tournament tournament = tournamentDaoImpl.findById(tournamentId);
		//	List<TournamentPlayerDetails> tournamentPlayerList=tournamentPlayerDetailsDaoImpl.findTournamentPlayerDetails(tournamentId);
			ArrayList<Player> tournamentPlayerList= playerDaoImpl.findPlayerbyTournament(tournamentId);
			tournamentMatchList= Util.generateTournamentSchedule(tournament,tournamentPlayerList);
			
			MatchDetails match= tournamentMatchList.get(0);
			System.out.println("before insert");
			matchDetailsDaoImpl.createMatchList(tournamentMatchList);
			System.out.println("after insert");
			}catch (Exception e) {
				throw new ResponeException(e);
			}
		return tournamentMatchList;
	}
	
	public List<List<Map<String,Object>>> getdisplayMatchListTournamentStanding(int tournamentId) throws ResponeException{
		String sql="select P.FIRST_NAME AS 'First Name',P.LAST_NAME AS 'Last Name',TP.RANKING AS 'Ranking',\n" + 
				"TP.MATCH_WON AS 'Match Won',TP.MATCH_LOST AS 'Match Lost',TP.SET_WON AS 'Set Won',TP.SET_LOST AS 'Set Won',TP.GAME_WON AS 'Game Won',TP.GAME_LOST AS 'Game Won',P.PLAYER_ID from TOURNAMENT_PLAYER_DETAILS TP\n" + 
				"INNER JOIN PLAYER P ON P.PLAYER_ID=TP.PLAYER_ID\n" + 
				"ORDER BY ISNULL(RANKING), RANKING ASC";
		 

		try {
			return tennisService.getDynamicReport(sql);
			}catch (Exception e) {
				throw new ResponeException(e);
			}
		
	}
	
	public List<Media>getMediaImagesForTournament(int tournamentId) throws ResponeException{
		List<Media> MediaList;
		try {
			return mediaDaoImpl.findMediaImagesbyTournament(tournamentId);
			}catch (Exception e) {
				throw new ResponeException(e);
			}
		
	}
}
