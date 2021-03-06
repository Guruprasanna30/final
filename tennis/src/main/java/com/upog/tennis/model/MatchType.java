package com.upog.tennis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MATCH_TYPE")
public class MatchType implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@Column(name = "MATCH_TYPE_ID")
	int id;
	@Column(name = "MATCH_TYPE_NAME")
	String name;
	@Column(name = "MATCH_TYPE_DISPLAY_NAME")
	String displayName;
	
	public MatchType() {}
	
	

	public MatchType(int id, String name, String displayName) {
		super();
		this.id = id;
		this.name = name;
		this.displayName = displayName;
	}



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

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String toString() {
		return "CourtType [id=" + id + ", name=" + name + ", displayName=" + displayName + "]";
	}



	


}
