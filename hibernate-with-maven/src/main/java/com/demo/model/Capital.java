package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "CAPITAL")
public class Capital {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CAPITAL_ID")
	private Integer capitalId;

	@Column(name = "CAPITAL_NAME")
	private String capitalName;

	@Column(name = "CAPITAL_POPULATION")
	private String capitalPopulation;

	public Capital() {
		super();
	}

	public Capital(String capitalName, String capitalPopulation) {
		this.capitalName = capitalName;
		this.capitalPopulation = capitalPopulation;
	}

	public Integer getCapitalId() {
		return capitalId;
	}

	public void setCapitalId(Integer capitalId) {
		this.capitalId = capitalId;
	}

	public String getCapitalName() {
		return capitalName;
	}

	public void setCapitalName(String capitalName) {
		this.capitalName = capitalName;
	}

	public String getCapitalPopulation() {
		return capitalPopulation;
	}

	public void setCapitalPopulation(String capitalPopulation) {
		this.capitalPopulation = capitalPopulation;
	}

}
