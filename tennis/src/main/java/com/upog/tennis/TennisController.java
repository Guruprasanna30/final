package com.upog.tennis;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.upog.tennis.service.MatchService;
import com.upog.tennis.service.PlayerService;
import com.upog.tennis.service.TennisInitService;
import com.upog.tennis.service.TennisService;
import com.upog.tennis.service.TournamentService;
import com.upog.tennis.util.Constant;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.upog.tennis.exception.CustomResponseEntityExceptionHandler;
import com.upog.tennis.exception.ResponeException;
import com.upog.tennis.model.Connection;
import com.upog.tennis.model.MatchDetails;
import com.upog.tennis.model.Media;
import com.upog.tennis.model.Player;


/**
 * Acts as a controller to handle actions related to Login of a user and getting
 * all the User Preferences.
 */
@Controller
public class TennisController  {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TennisService tennisService;
	
	@Autowired  
	private TennisInitService tennisInitService;
	
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private MatchService matchService;
	
	@Autowired
	private TournamentService tournamentService;
	
	
	
	
	
	@RequestMapping(method=RequestMethod.GET, path="/message")
	@ResponseBody
	public String getMessage() throws ResponeException {
		System.out.println("inside dashboard 1");
		
		return "csalayout123";   
	}
	
	
	
	@RequestMapping(method=RequestMethod.GET, path="/dynamicReport")
	@ResponseBody
	public List<List<Map<String,Object>>> getDynamicReport(@RequestParam Map<String,String> requestParams) throws ResponeException {
		String SQL=requestParams.get("dynamicReportSQL");
		//String connectionName=requestParams.get("selectedConnection");		
		return tennisService.getDynamicReport(SQL);		
		
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/connectionList") 
	@ResponseBody
	public List<Connection> getConnectionList() {
		 return tennisInitService.getConnectionList();
	 
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/generateTournamentSchedule") 
	@ResponseBody
	public List<MatchDetails> generateTournamentSchedule(@RequestParam Map<String,String> requestParams) throws ResponeException {
		int  tournamentId=1;//Integer.parseInt(requestParams.get("tournamentId"));
		return tournamentService.generateTournamentSchedule(tournamentId);
	 
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/player/id/{playerId}") 
	@ResponseBody
	public Player getPlayerByURLId(@PathVariable int playerId) throws ResponeException {
		 return playerService.findPlayerById(playerId);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/playerById") 
	@ResponseBody
	public Player getPlayerById(@RequestParam Map<String,String> requestParams) throws ResponeException {
		int playerId=Integer.parseInt(requestParams.get("playerId"));
		 return playerService.findPlayerById(playerId);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/playerByUserName") 
	@ResponseBody
	public Player getPlayerByUserName(@RequestParam Map<String,String> requestParams) throws ResponeException {
		String userName=requestParams.get("userName");
		 return playerService.findPlayerByUserName(userName);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/playerByName") 
	@ResponseBody
	public List<Player> getPlayerByName(@RequestParam Map<String,String> requestParams) throws ResponeException {
		String name=requestParams.get("name");
		 return playerService.findPlayerName(name);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/matchByTournamentId") 
	@ResponseBody
	public List<MatchDetails> getMatchByTournament(@RequestParam Map<String,String> requestParams) throws ResponeException {
		int tournamentId=Integer.parseInt(requestParams.get("tournamentId"));
		 return matchService.findMatchbyTournamentId(tournamentId);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/displayMatchByTournamentId") 
	@ResponseBody
	public List<List<Map<String,Object>>> getdisplayMatchByTournament(@RequestParam Map<String,String> requestParams) throws ResponeException {
		int tournamentId=1;//Integer.parseInt(requestParams.get("tournamentId"));
		 return matchService.getdisplayMatchByTournament(tournamentId);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/displayMatchList") 
	@ResponseBody
	public List<List<Map<String,Object>>> getdisplayMatchList(@RequestParam Map<String,String> requestParams) throws ResponeException {
		int tournamentId=1;//Integer.parseInt(requestParams.get("tournamentId"));
		 return matchService.getdisplayMatchList(tournamentId);
	}
	
	
	@RequestMapping(method=RequestMethod.GET, path="/displayTournamentStanding")  
	@ResponseBody
	public List<List<Map<String,Object>>> getdisplayMatchListTournamentStanding(@RequestParam Map<String,String> requestParams) throws ResponeException {
		int tournamentId=Integer.parseInt(requestParams.get("tournamentId"));
		 return tournamentService.getdisplayMatchListTournamentStanding(tournamentId);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/mediaImagesForTournament")  
	@ResponseBody
	public List<Media> getMediaImagesForTournament(@RequestParam Map<String,String> requestParams) throws ResponeException {
		int tournamentId=1;//Integer.parseInt(requestParams.get("tournamentId"));
		 return tournamentService.getMediaImagesForTournament(tournamentId);
	}

	
	
	
}  
