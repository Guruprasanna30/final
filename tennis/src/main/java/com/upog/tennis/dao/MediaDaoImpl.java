package com.upog.tennis.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upog.tennis.model.MatchDetails;
import com.upog.tennis.model.Media;
import com.upog.tennis.repository.MediaRepository;


@Component
public class MediaDaoImpl {
	
	@Autowired
	private MediaRepository mediaRepository;
	
	public List<Media>findMediabyMediaId(int mediaId){
		return mediaRepository.findByMediaId(mediaId);
	}
	
	public List<Media>findMediaImagesbyTournament(int tournamentId){
		return mediaRepository.findMediaImagesbyTournament(tournamentId);
	}
	
}
