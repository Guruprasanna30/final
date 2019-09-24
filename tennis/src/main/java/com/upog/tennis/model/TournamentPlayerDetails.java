package com.upog.tennis.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TOURNAMENT_PLAYER_DETAILS")
public class TournamentPlayerDetails  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	@Column(name = "TOURNAMENT_PLAYER_ID")
	int id;

	@Column(name = "RANKING")
	Integer ranking;
	 
	@Column(name = "MATCH_WON")
	Integer matchWon;
	@Column(name = "MATCH_LOST")
	Integer matchLost;
	@Column(name = "SET_WON")
	Integer setWon;
	@Column(name = "SET_LOST")
	Integer setLost;
	@Column(name = "GAME_WON")
	Integer gameWon;
	@Column(name = "GAME_LOST")
	Integer gameLost;
	
	

	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PLAYER_ID", referencedColumnName = "PLAYER_ID")
    private Player player;
	@ManyToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "TOURNAMENT_ID", referencedColumnName = "TOURNAMENT_ID")
    private Tournament tournament;
	
	public TournamentPlayerDetails()  {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	public Integer getMatchWon() {
		return matchWon;
	}

	public void setMatchWon(Integer matchWon) {
		this.matchWon = matchWon;
	}

	public Integer getMatchLost() {
		return matchLost;
	}

	public void setMatchLost(Integer matchLost) {
		this.matchLost = matchLost;
	}

	public Integer getSetWon() {
		return setWon;
	}

	public void setSetWon(Integer setWon) {
		this.setWon = setWon;
	}

	public Integer getSetLost() {
		return setLost;
	}

	public void setSetLost(Integer setLost) {
		this.setLost = setLost;
	}

	public Integer getGameWon() {
		return gameWon;
	}

	public void setGameWon(Integer gameWon) {
		this.gameWon = gameWon;
	}

	public Integer getGameLost() {
		return gameLost;
	}

	public void setGameLost(Integer gameLost) {
		this.gameLost = gameLost;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public String toString() {
		return "TournamentPlayerDetails [id=" + id +  ", ranking=" + ranking + ", matchWon="
				+ matchWon + ", matchLost=" + matchLost + ", setWon=" + setWon + ", setLost=" + setLost + ", gameWon="
				+ gameWon + ", gameLost=" + gameLost + ", player=" + player + "]";
	}

   
	

	
	
}
