package com.upog.tennis.util;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.upog.tennis.model.Tournament;

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
   
   public static  void generateTournamentSchedule(Tournament tournament) {

	   logger.debug("inside Util "+ tournament);

	   
   }
   
   
   
}
