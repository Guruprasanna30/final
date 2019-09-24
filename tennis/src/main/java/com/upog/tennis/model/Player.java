package com.upog.tennis.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.upog.tennis.model.Media;


import org.hibernate.annotations.Formula;
import org.hibernate.annotations.JoinFormula;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PLAYER")
public class Player implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@Column(name = "PLAYER_ID")
	int id;
	@Column(name = "USER_NAME")
	String userName;
	@JsonIgnore
	@Column(name = "PASSWORD")
	String password;
	

	@Column(name = "FIRST_NAME")
	String firstName;
	@Column(name = "LAST_NAME")
	String lastName;
	@Column(name = "EMAIL_ID")
	String emailId;
	@Column(name = "PHONE_NO")
	String phoneNo;
	@Column(name = "DESCRIPTION")
	String description;
	
	@Column(name = "LEVEL")
	Float level;
	@Column(name = "TOURNAMENT_WON")
	Integer tournamentWon;
	@Column(name = "REG_MATCH_PLAYED")
	Integer noOfRegularMatch;
	@Column(name = "REG_MATCH_WON")
	Integer noOfRegularMatchWon;
	@Column(name = "REG_MATCH_DRAWN")
	Integer noOfRegularMatchDrawn;
	@Column(name = "TOURNAMENT_MATCH_PLAYED")
	Integer noOfTournamentMatch;
	@Column(name = "TOURNAMENT_MATCH_WON")
	Integer noOfTournamentMatchWon;
	@Column(name = "TOURNAMENT_MATCH_DRAWN")
	Integer noOfTournamentMatchDrawn;
	@Column(name = "RAITNG")
	Integer rating;
	@Column(name = "TOURNAMENT_RAITNG")
	Integer tournamentRating;


	@OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
    private Address address;
	
	@OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "SEX_NAME", referencedColumnName = "SEX_NAME")
    private Sex sex;
	
	//@OneToMany ( mappedby = "media.strObjectGUID"    )
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MEDIA_ID", referencedColumnName = "MEDIA_ID")
    private Media media;
	
	
	public Player() {}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Float getLevel() {
		return level;
	}


	public void setLevel(Float level) {
		this.level = level;
	}


	public Integer getTournamentWon() {
		return tournamentWon;
	}


	public void setTournamentWon(Integer tournamentWon) {
		this.tournamentWon = tournamentWon;
	}


	public Integer getNoOfRegularMatch() {
		return noOfRegularMatch;
	}


	public void setNoOfRegularMatch(Integer noOfRegularMatch) {
		this.noOfRegularMatch = noOfRegularMatch;
	}


	public Integer getNoOfRegularMatchWon() {
		return noOfRegularMatchWon;
	}


	public void setNoOfRegularMatchWon(Integer noOfRegularMatchWon) {
		this.noOfRegularMatchWon = noOfRegularMatchWon;
	}


	public Integer getNoOfRegularMatchDrawn() {
		return noOfRegularMatchDrawn;
	}


	public void setNoOfRegularMatchDrawn(Integer noOfRegularMatchDrawn) {
		this.noOfRegularMatchDrawn = noOfRegularMatchDrawn;
	}


	public Integer getNoOfTournamentMatch() {
		return noOfTournamentMatch;
	}


	public void setNoOfTournamentMatch(Integer noOfTournamentMatch) {
		this.noOfTournamentMatch = noOfTournamentMatch;
	}


	public Integer getNoOfTournamentMatchWon() {
		return noOfTournamentMatchWon;
	}


	public void setNoOfTournamentMatchWon(Integer noOfTournamentMatchWon) {
		this.noOfTournamentMatchWon = noOfTournamentMatchWon;
	}


	public Integer getNoOfTournamentMatchDrawn() {
		return noOfTournamentMatchDrawn;
	}


	public void setNoOfTournamentMatchDrawn(Integer noOfTournamentMatchDrawn) {
		this.noOfTournamentMatchDrawn = noOfTournamentMatchDrawn;
	}


	public Integer getRating() {
		return rating;
	}


	public void setRating(Integer rating) {
		this.rating = rating;
	}


	public Integer getTournamentRating() {
		return tournamentRating;
	}


	public void setTournamentRating(Integer tournamentRating) {
		this.tournamentRating = tournamentRating;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public Sex getSex() {
		return sex;
	}


	public void setSex(Sex sex) {
		this.sex = sex;
	}


	public Media getMedia() {
		return media;
	}


	public void setMedia(Media media) {
		this.media = media;
	}


	@Override
	public String toString() {
		return "Player [id=" + id + ", userName=" + userName + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", emailId=" + emailId + ", phoneNo=" + phoneNo + ", description="
				+ description + ", level=" + level + ", tournamentWon=" + tournamentWon + ", noOfRegularMatch="
				+ noOfRegularMatch + ", noOfRegularMatchWon=" + noOfRegularMatchWon + ", noOfRegularMatchDrawn="
				+ noOfRegularMatchDrawn + ", noOfTournamentMatch=" + noOfTournamentMatch + ", noOfTournamentMatchWon="
				+ noOfTournamentMatchWon + ", noOfTournamentMatchDrawn=" + noOfTournamentMatchDrawn + ", rating="
				+ rating + ", tournamentRating=" + tournamentRating + ", address=" + address + ", sex=" + sex
				+ ", media=" + media + "]";
	}

	

}
