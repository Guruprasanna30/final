package com.upog.tennis.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TOURNAMENT")
public class Tournament  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id 
	@Column(name = "TOURNAMENT_ID")
	int id;
	

	@Column(name = "TOURNAMENT_NAME")
	String name;
	 
	@Column(name = "PRIZE_1ST")
	Integer prize1st;
	@Column(name = "PRIZE_2ND")
	Integer prize2nd;
	@Column(name = "PRIZE_3RD")
	Integer prize3rd;
	@Column(name = "ENTREE_FEE")
	Integer entreeFee;
	
	@Column(name = "DIVISION")
	Float division;
	
	@Column(name = "MATCH_INTERVAL_DAYS")
	Integer matchInterval;
	@Column(name = "START_DATE")
	Date stratDate;
	@Column(name = "END_DATE")
	Date endDate;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "GAME_TYPE_ID", referencedColumnName = "GAME_TYPE_ID")
    private GameType gameType;

	  
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "WINNER_ID", referencedColumnName = "PLAYER_ID")
    private Player winnerPlayer;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RUNNER_ID", referencedColumnName = "PLAYER_ID")
    private Player runnerPlayer;
	

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SCHEDULE_LOGIC_ID", referencedColumnName = "SCHEDULE_LOGIC_ID")
    private ScheduleLogic scheduleLogic;
	
	
	public Tournament() {}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getPrize1st() {
		return prize1st;
	}


	public void setPrize1st(Integer prize1st) {
		this.prize1st = prize1st;
	}


	public Integer getPrize2nd() {
		return prize2nd;
	}


	public void setPrize2nd(Integer prize2nd) {
		this.prize2nd = prize2nd;
	}


	public Integer getPrize3rd() {
		return prize3rd;
	}


	public void setPrize3rd(Integer prize3rd) {
		this.prize3rd = prize3rd;
	}


	public Integer getEntreeFee() {
		return entreeFee;
	}


	public void setEntreeFee(Integer entreeFee) {
		this.entreeFee = entreeFee;
	}


	public Float getDivision() {
		return division;
	}


	public void setDivision(Float division) {
		this.division = division;
	}


	public Integer getMatchInterval() {
		return matchInterval;
	}


	public void setMatchInterval(Integer matchInterval) {
		this.matchInterval = matchInterval;
	}


	public Date getStratDate() {
		return stratDate;
	}


	public void setStratDate(Date stratDate) {
		this.stratDate = stratDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public GameType getGameType() {
		return gameType;
	}


	public void setGameType(GameType gameType) {
		this.gameType = gameType;
	}


	public Player getWinnerPlayer() {
		return winnerPlayer;
	}


	public void setWinnerPlayer(Player winnerPlayer) {
		this.winnerPlayer = winnerPlayer;
	}


	public Player getRunnerPlayer() {
		return runnerPlayer;
	}


	public void setRunnerPlayer(Player runnerPlayer) {
		this.runnerPlayer = runnerPlayer;
	}


	public ScheduleLogic getScheduleLogic() {
		return scheduleLogic;
	}


	public void setScheduleLogic(ScheduleLogic scheduleLogic) {
		this.scheduleLogic = scheduleLogic;
	}


	@Override
	public String toString() {
		return "Tournament [id=" + id + ", name=" + name + ", prize1st=" + prize1st + ", prize2nd=" + prize2nd
				+ ", prize3rd=" + prize3rd + ", entreeFee=" + entreeFee + ", matchInterval=" + matchInterval
				+ ", stratDate=" + stratDate + ", endDate=" + endDate + ", gameType=" + gameType + ", winnerPlayer="
				+ winnerPlayer + ", runnerPlayer=" + runnerPlayer + ", scheduleLogic=" + scheduleLogic + "]";
	}


	

    
	
}
