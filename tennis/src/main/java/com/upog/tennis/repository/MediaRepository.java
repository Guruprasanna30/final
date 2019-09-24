package com.upog.tennis.repository;

import org.springframework.stereotype.Repository;

import com.upog.tennis.model.Media;
import com.upog.tennis.model.Player;
import com.upog.tennis.model.TournamentPlayerDetails;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface MediaRepository extends JpaRepository<Media, Integer>{
	
	public List<Media> findByMediaId(int tournamentMediaId); 
	
	@Query(value="   SELECT * FROM MEDIA M\n" + 
			" INNER JOIN TOURNAMENT T ON M.MEDIA_ID=T.MEDIA_ID\n" + 
			" WHERE  M.IMG_LINK IS NOT NULL AND T.TOURNAMENT_ID = :tournamentId ", nativeQuery=true)   
	public ArrayList<Media> findMediaImagesbyTournament(@Param("tournamentId") int tournamentId );


}
