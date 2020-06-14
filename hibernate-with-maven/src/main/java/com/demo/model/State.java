package com.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "STATE")
public class State implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "STATE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer stateId;
	
	@Column(name = "STATE_NAME")
	private String stateName;
	
	@Column(name = "STATE_POPULATION")
	private String statePopulation;

	public State() {
		super();
	}

	public State(String stateName, String statePopulation) {
		this.stateName = stateName;
		this.statePopulation = statePopulation;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStatePopulation() {
		return statePopulation;
	}

	public void setStatePopulation(String statePopulation) {
		this.statePopulation = statePopulation;
	}

}
