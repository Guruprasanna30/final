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
import com.upog.tennis.dao.PlayerDaoImpl;
import com.upog.tennis.dao.ReportsDaoImpl;
import com.upog.tennis.dao.TournamentDaoImpl;
import com.upog.tennis.dao.TournamentPlayerDetailsDaoImpl;
import com.upog.tennis.exception.ResponeException;
import com.upog.tennis.model.MatchDetails;
import com.upog.tennis.model.Player;
import com.upog.tennis.model.Tournament;
import com.upog.tennis.model.TournamentPlayerDetails;
import com.upog.tennis.repository.TournamentRepository;
import com.upog.tennis.util.Constant;
import com.upog.tennis.util.Util; 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class MatchService {
	
	@Autowired
	MatchDetailsDaoImpl matchDetailsDaoImpl;
	
	@Autowired
	TennisService tennisService;

	  private static final Logger logger = LoggerFactory.getLogger(MatchService.class);
	  
	public List<MatchDetails> findMatchbyTournamentId(int tournamentId) throws ResponeException{
		List<MatchDetails> tournamentMatchList =null;
		try {
			tournamentMatchList=matchDetailsDaoImpl.findMatchDetailsbyTournament(tournamentId);
			}catch (Exception e) {
				throw new ResponeException(e);
			}
		return tournamentMatchList;
	} 
	
	
	public List<List<Map<String,Object>>> getdisplayMatchByTournament(int tournamentId) throws ResponeException{
		String sql="select MD.MATCH_ID,MD.MATCH_NAME,MD.START_DATE,MD.END_DATE,P1.FIRST_NAME AS PLAYER1,P2.FIRST_NAME AS PLAYER2,P3.FIRST_NAME AS WINNER , P4.FIRST_NAME AS RUNNER\n" + 
				",CONCAT(WINNER_SET1_SCORE,'-',RUNNER_SET1_SCORE,',',WINNER_SET2_SCORE,'-',RUNNER_SET2_SCORE,',',WINNER_SET3_SCORE,'-',RUNNER_SET3_SCORE) AS SCORE , RT.RESULT_TYPE_DISPLAY_NAME\n" + 
				"from MATCH_DETAILS MD\n" + 
				"INNER JOIN PLAYER P1 ON P1.PLAYER_ID=MD.PLAYER_ID_1\n" + 
				"INNER JOIN PLAYER P2 ON P2.PLAYER_ID=MD.PLAYER_ID_2\n" + 
				"LEFT JOIN SCORE S ON S.SCORE_ID=MD.SCORE_ID\n" + 
				"LEFT JOIN PLAYER P3 ON P3.PLAYER_ID=S.WINNER_PLAYER_ID\n" + 
				"LEFT JOIN PLAYER P4 ON P4.PLAYER_ID=S.RUNNER_PLAYER_ID\n" + 
				"LEFT JOIN RESULT_TYPE RT ON RT.RESULT_TYPE_ID=MD.RESULT_TYPE_ID \n" + 
				"ORDER BY MATCH_ID ";
		 

		try {
			return tennisService.getDynamicReport(sql);
			}catch (Exception e) {
				throw new ResponeException(e);
			}
		
	} 
	
	public List<List<Map<String,Object>>> getdisplayMatchList(int tournamentId) throws ResponeException{
		String sql="select MD.MATCH_ID,MD.MATCH_NAME,MD.START_DATE,MD.END_DATE,P1.FIRST_NAME AS PLAYER1,P2.FIRST_NAME AS PLAYER2,P3.FIRST_NAME AS WINNER , P4.FIRST_NAME AS RUNNER\n" + 
				",CONCAT(WINNER_SET1_SCORE,'-',RUNNER_SET1_SCORE,',',WINNER_SET2_SCORE,'-',RUNNER_SET2_SCORE,',',WINNER_SET3_SCORE,'-',RUNNER_SET3_SCORE) AS SCORE , RT.RESULT_TYPE_DISPLAY_NAME\n" + 
				"from MATCH_DETAILS MD\n" + 
				"INNER JOIN PLAYER P1 ON P1.PLAYER_ID=MD.PLAYER_ID_1\n" + 
				"INNER JOIN PLAYER P2 ON P2.PLAYER_ID=MD.PLAYER_ID_2\n" + 
				"LEFT JOIN SCORE S ON S.SCORE_ID=MD.SCORE_ID\n" + 
				"LEFT JOIN PLAYER P3 ON P3.PLAYER_ID=S.WINNER_PLAYER_ID\n" + 
				"LEFT JOIN PLAYER P4 ON P4.PLAYER_ID=S.RUNNER_PLAYER_ID\n" + 
				"LEFT JOIN RESULT_TYPE RT ON RT.RESULT_TYPE_ID=MD.RESULT_TYPE_ID \n" + 
				"ORDER BY MATCH_ID ";
		 

		try {
			return tennisService.getDynamicReport(sql);
			}catch (Exception e) {
				throw new ResponeException(e);
			}
		
	} 
	
	
	
}
