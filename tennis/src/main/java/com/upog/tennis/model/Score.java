package com.upog.tennis.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SCORE")
public class Score implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@Column(name = "SCORE_ID")
	int id;
	@Column(name = "WINNER_SET1_SCORE")
	Integer winnerSet1Score;
	@Column(name = "RUNNER_SET1_SCORE")
	Integer runnerSet1Score;
	@Column(name = "DURATION_SET1_MINS")
	Integer durationSet1Mins;
	@Column(name = "WINNER_SET2_SCORE")
	Integer winnerSet2Score;
	@Column(name = "RUNNER_SET2_SCORE")
	Integer runnerSet2Score;
	@Column(name = "DURATION_SET2_MINS")
	Integer durationSet2Mins;
	@Column(name = "WINNER_SET3_SCORE")
	Integer winnerSet3Score;
	@Column(name = "RUNNER_SET3_SCORE")
	Integer runnerSet3Score;
	@Column(name = "DURATION_SET3_MINS")
	Integer durationSet3Mins;
	@Column(name = "WINNER_SET4_SCORE")
	Integer winnerSet4Score;
	@Column(name = "RUNNER_SET4_SCORE")
	Integer runnerSet4Score;
	@Column(name = "DURATION_SET4_MINS")
	Integer durationSet4Mins;
	@Column(name = "WINNER_SET5_SCORE")
	Integer winnerSet5Score;
	@Column(name = "RUNNER_SET5_SCORE")
	Integer runnerSet5Score;
	@Column(name = "DURATION_SET5_MINS")
	Integer durationSet5Mins;
	

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "WINNER_PLAYER_ID", referencedColumnName = "PLAYER_ID")
    private Player winnerPlayer;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RUNNER_PLAYER_ID", referencedColumnName = "PLAYER_ID")
    private Player runnerPlayer;
	
	public Score() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getWinnerSet1Score() {
		return winnerSet1Score;
	}

	public void setWinnerSet1Score(Integer winnerSet1Score) {
		this.winnerSet1Score = winnerSet1Score;
	}

	public Integer getRunnerSet1Score() {
		return runnerSet1Score;
	}

	public void setRunnerSet1Score(Integer runnerSet1Score) {
		this.runnerSet1Score = runnerSet1Score;
	}

	public Integer getDurationSet1Mins() {
		return durationSet1Mins;
	}

	public void setDurationSet1Mins(Integer durationSet1Mins) {
		this.durationSet1Mins = durationSet1Mins;
	}

	public Integer getWinnerSet2Score() {
		return winnerSet2Score;
	}

	public void setWinnerSet2Score(Integer winnerSet2Score) {
		this.winnerSet2Score = winnerSet2Score;
	}

	public Integer getRunnerSet2Score() {
		return runnerSet2Score;
	}

	public void setRunnerSet2Score(Integer runnerSet2Score) {
		this.runnerSet2Score = runnerSet2Score;
	}

	public Integer getDurationSet2Mins() {
		return durationSet2Mins;
	}

	public void setDurationSet2Mins(Integer durationSet2Mins) {
		this.durationSet2Mins = durationSet2Mins;
	}

	public Integer getWinnerSet3Score() {
		return winnerSet3Score;
	}

	public void setWinnerSet3Score(Integer winnerSet3Score) {
		this.winnerSet3Score = winnerSet3Score;
	}

	public Integer getRunnerSet3Score() {
		return runnerSet3Score;
	}

	public void setRunnerSet3Score(Integer runnerSet3Score) {
		this.runnerSet3Score = runnerSet3Score;
	}

	public Integer getDurationSet3Mins() {
		return durationSet3Mins;
	}

	public void setDurationSet3Mins(Integer durationSet3Mins) {
		this.durationSet3Mins = durationSet3Mins;
	}

	public Integer getWinnerSet4Score() {
		return winnerSet4Score;
	}

	public void setWinnerSet4Score(Integer winnerSet4Score) {
		this.winnerSet4Score = winnerSet4Score;
	}

	public Integer getRunnerSet4Score() {
		return runnerSet4Score;
	}

	public void setRunnerSet4Score(Integer runnerSet4Score) {
		this.runnerSet4Score = runnerSet4Score;
	}

	public Integer getDurationSet4Mins() {
		return durationSet4Mins;
	}

	public void setDurationSet4Mins(Integer durationSet4Mins) {
		this.durationSet4Mins = durationSet4Mins;
	}

	public Integer getWinnerSet5Score() {
		return winnerSet5Score;
	}

	public void setWinnerSet5Score(Integer winnerSet5Score) {
		this.winnerSet5Score = winnerSet5Score;
	}

	public Integer getRunnerSet5Score() {
		return runnerSet5Score;
	}

	public void setRunnerSet5Score(Integer runnerSet5Score) {
		this.runnerSet5Score = runnerSet5Score;
	}

	public Integer getDurationSet5Mins() {
		return durationSet5Mins;
	}

	public void setDurationSet5Mins(Integer durationSet5Mins) {
		this.durationSet5Mins = durationSet5Mins;
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

	@Override
	public String toString() {
		return "Score [id=" + id + ", winnerSet1Score=" + winnerSet1Score + ", runnerSet1Score=" + runnerSet1Score
				+ ", durationSet1Mins=" + durationSet1Mins + ", winnerSet2Score=" + winnerSet2Score
				+ ", runnerSet2Score=" + runnerSet2Score + ", durationSet2Mins=" + durationSet2Mins
				+ ", winnerSet3Score=" + winnerSet3Score + ", runnerSet3Score=" + runnerSet3Score
				+ ", durationSet3Mins=" + durationSet3Mins + ", winnerSet4Score=" + winnerSet4Score
				+ ", runnerSet4Score=" + runnerSet4Score + ", durationSet4Mins=" + durationSet4Mins
				+ ", winnerSet5Score=" + winnerSet5Score + ", runnerSet5Score=" + runnerSet5Score
				+ ", durationSet5Mins=" + durationSet5Mins + ", winnerPlayer=" + winnerPlayer + ", runnerPlayer="
				+ runnerPlayer + "]";
	}

	
	
}
