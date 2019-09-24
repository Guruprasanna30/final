package com.upog.tennis.util;




import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.upog.tennis.model.GameType;
import com.upog.tennis.model.MatchDetails;
import com.upog.tennis.model.MatchType;
import com.upog.tennis.model.Player;
import com.upog.tennis.model.Tournament;
import com.upog.tennis.model.TournamentPlayerDetails;

public abstract class Util {

    private static final Logger logger = LoggerFactory.getLogger(Util.class);

   public static String toCamelCase(String input) {
	 if(input==null || input.length()==0)
		 return input;
	   
	   StringBuffer sb = new StringBuffer();
	    for (String s : input.split("_")) {
	        sb.append(Character.toUpperCase(s.charAt(0)));	        
	        sb.append(s.substring(1, s.length()).toLowerCase());
	        sb.append(Constant.SPACE);
	    }
	   return sb.toString().trim();
   }
   
   public static List<MatchDetails> generateTournamentSchedule(Tournament tournament, ArrayList<Player> tournamentPlayer) {
	   ArrayList<MatchDetails> tournamentMatches = new ArrayList<MatchDetails>();
	   try {
  
	   logger.debug("inside Util "+ tournament);
	  
	   if (tournamentPlayer==null || tournamentPlayer.size()==0) {return tournamentMatches;}
	   int size= tournamentPlayer.size();
	 
	   
	   int halfSize = size/ 2;
	   Date currentDate=new Date();
	   Date startDate= tournament.getStratDate();
	   int matchStart=1;
       int matchTypeId=2;
       
       MatchType matchType= new MatchType(2, "TOURNAMENT_LEAGUE", "Tournament League");
       
       GameType gameType= new GameType(1,"SINGLES","Singles");
       String  name= tournament.getName();
       float division= tournament.getDivision();
	   
	  tournamentPlayer.sort((o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName())); 
      if( Constant.GAME_TYPE_SINGLES.equals(tournament.getGameType().getName()) 
    		 || Constant.GAME_TYPE_MIXED_SINGLES.equals(tournament.getGameType().getName())) {    	 
    	 if(Constant.SCHEDULE_LOGIC_ROUND_ROBIN.equals(tournament.getScheduleLogic().getName()) ) {
    		 for(int i=0; i < tournamentPlayer.size()-1; i++) {
    			 
    			 
    			  long ltime=startDate.getTime()+7*24*60*60*1000;
    			   Date endDate=new Date(ltime);
    			   
    			   logger.debug(i+"-->"+startDate+ " "+ endDate );
    			   for(int j=0;j<halfSize;j++) {
    				   logger.debug(tournamentPlayer.get(j).getFirstName() + " vs " + tournamentPlayer.get(size-1-j).getFirstName());
    			
    				   MatchDetails match=	new MatchDetails(matchStart, name+ Constant.HYPHEN + Constant.ROUND + (i+1)+ Constant.HYPHEN+ Constant.MATCH+ matchStart
    							,startDate,endDate ,currentDate
    							,tournamentPlayer.get(j),tournamentPlayer.get(size-1-j),null,null  
    							,matchType,gameType,tournament );
    				   tournamentMatches.add(match);
    				matchStart++;
    			   }
    			   tournamentPlayer.add(1, tournamentPlayer.get(size-1));
    			   tournamentPlayer.remove(size);
    			
    			 
    			 startDate=endDate;
    		 }
    		 
    		 
    	 }
    	 
     }
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	   
	   return tournamentMatches;
	   
   }
   
   
   
}
