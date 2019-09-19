package com.upog.tennis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

@Entity
@Table(name = "MATCH_DETAILS")
public class MatchDetails {

	@Id 
	@Column(name = "MATCH_ID")
	int id;
	
	@Column(name = "COMMENT")
	String comment;
	 
	@Column(name = "MATCH_NAME")
	String name;
	
	@Column(name = "FROM_DATE")
	Date fromDate;
	
	@Column(name = "TO_DATE")
	Date toDate;
	
	@Column(name = "PLAYED_TIME")
	Date playedTime;
	
	@Column(name = "CREATED_TIME")
	Date createdTime;
	

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PLAYER_ID_1", referencedColumnName = "PLAYER_ID")
    private Player player1;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PLAYER_ID_2", referencedColumnName = "PLAYER_ID")
    private Player player2;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PLAYER_ID_3", referencedColumnName = "PLAYER_ID")
    private Player player3;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PLAYER_ID_4", referencedColumnName = "PLAYER_ID")
    private Player player4;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MATCH_TYPE_ID", referencedColumnName = "MATCH_TYPE_ID")
    private MatchType matchType;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "GAME_TYPE_ID", referencedColumnName = "GAME_TYPE_ID")
    private GameType gameType;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RESULT_TYPE_ID", referencedColumnName = "RESULT_TYPE_ID")
    private ResultType resultType;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TOURNAMENT_ID", referencedColumnName = "TOURNAMENT_ID")
    private Tournament tournament;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SCORE_ID", referencedColumnName = "SCORE_ID")
    private Score score;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COURT_ID", referencedColumnName = "COURT_ID")
    private Court court;
	
	@OneToMany
	//@JoinColumn( name = "MEDIA_ID", referencedColumnName = "MEDIA_ID"    )
	@Formula("SELECT * FROM MEDIA WHERE MEDIA_ID = MEDIA_ID")
	private List<Media> media= new ArrayList<Media>();
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SCHEDULE_ID_1", referencedColumnName = "SCHEDULE_ID")
    private Schedule schedule1;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SCHEDULE_ID_2", referencedColumnName = "SCHEDULE_ID")
    private Schedule schedule2;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SCHEDULE_ID_3", referencedColumnName = "SCHEDULE_ID")
    private Schedule schedule3;
	
	public MatchDetails() {}

	
	
	public MatchDetails(int id, String name, Date fromDate, Date toDate, Date createdTime, Player player1,
			Player player2, Player player3, Player player4, MatchType matchType, GameType gameType,
			Tournament tournament) {
		super();
		this.id = id;
		this.name = name;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.createdTime = createdTime;
		this.player1 = player1;
		this.player2 = player2;
		this.player3 = player3;
		this.player4 = player4;
		this.matchType = matchType;
		this.gameType = gameType;
		this.tournament = tournament;
	}
	




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Date getPlayedTime() {
		return playedTime;
	}

	public void setPlayedTime(Date playedTime) {
		this.playedTime = playedTime;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public Player getPlayer3() {
		return player3;
	}

	public void setPlayer3(Player player3) {
		this.player3 = player3;
	}

	public Player getPlayer4() {
		return player4;
	}

	public void setPlayer4(Player player4) {
		this.player4 = player4;
	}

	public MatchType getMatchType() {
		return matchType;
	}

	public void setMatchType(MatchType matchType) {
		this.matchType = matchType;
	}

	public GameType getGameType() {
		return gameType;
	}

	public void setGameType(GameType gameType) {
		this.gameType = gameType;
	}

	public ResultType getResultType() {
		return resultType;
	}

	public void setResultType(ResultType resultType) {
		this.resultType = resultType;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public Court getCourt() {
		return court;
	}

	public void setCourt(Court court) {
		this.court = court;
	}

	public List<Media> getMedia() {
		return media;
	}


	public void setMedia(List<Media> media) {
		this.media = media;
	}

	public Schedule getSchedule1() {
		return schedule1;
	}

	public void setSchedule1(Schedule schedule1) {
		this.schedule1 = schedule1;
	}

	public Schedule getSchedule2() {
		return schedule2;
	}

	public void setSchedule2(Schedule schedule2) {
		this.schedule2 = schedule2;
	}

	public Schedule getSchedule3() {
		return schedule3;
	}

	public void setSchedule3(Schedule schedule3) {
		this.schedule3 = schedule3;
	}

	@Override
	public String toString() {
		return "MatchDetails [id=" + id + ", comment=" + comment + ", name=" + name + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + ", playedTime=" + playedTime + ", createdTime=" + createdTime + ", player1="
				+ player1 + ", player2=" + player2 + ", player3=" + player3 + ", player4=" + player4 + ", matchType="
				+ matchType + ", gameType=" + gameType + ", resultType=" + resultType + ", tournament=" + tournament
				+ ", score=" + score + ", court=" + court + ", media=" + media + ", schedule1=" + schedule1
				+ ", schedule2=" + schedule2 + ", schedule3=" + schedule3 + "]";
	}

		
	
	
}
