package com.upog.tennis.repository;

import org.springframework.stereotype.Repository;

import com.upog.tennis.model.Player;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{
	
	
	@Query(value="  SELECT P.* FROM PLAYER P \n" + 
			"    INNER JOIN  TOURNAMENT_PLAYER_DETAILS TP ON P.PLAYER_ID=TP.PLAYER_ID\n" + 
			"    INNER JOIN TOURNAMENT T ON T.TOURNAMENT_ID=TP.TOURNAMENT_ID where T.TOURNAMENT_ID = :tournamentId ", nativeQuery=true)   
	public ArrayList<Player> findPlayerbyTournament(@Param("tournamentId") int tournamentId );
	
	public Player findById(int Id);
	
	@Query(value=" select * from PLAYER\n" + 
			"WHERE UPPER(USER_NAME) LIKE :name \n" + 
			"OR UPPER(FIRST_NAME)LIKE :name \n" + 
			"OR UPPER(LAST_NAME)LIKE :name ", nativeQuery=true) 
	public List<Player> findPlayerByName(@Param("name") String name );
	
	public Player findByUserName(String firstName);

}
