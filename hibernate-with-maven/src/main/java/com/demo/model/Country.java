package com.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "COUNTRY")
public class Country implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COUNTRY_ID")
	private Integer countryId;

	@Column(name = "COUNTRY_NAME")
	private String countryName;

	@Column(name = "COUNTRY_POPULATION")
	private String countryPopuation;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "COUNTRY_STATE", joinColumns = {
			@JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID") }, inverseJoinColumns = {
					@JoinColumn(name = "STATE_ID", referencedColumnName = "STATE_ID") })
	private Collection<State> states = new ArrayList<State>();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CAPITAL_ID", referencedColumnName = "CAPITAL_ID")
	private Capital capital;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "COUNTRY_LANGUAGE", joinColumns = {
			@JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID") }, inverseJoinColumns = {
					@JoinColumn(name = "LANGUAGE_ID", referencedColumnName = "LANGUAGE_ID") })
	private Collection<Language> languages = new ArrayList<Language>();

	public Country() {
		super();
	}

	public Country(String countryName, String countryPopulation) {
		this.countryName = countryName;
		this.countryPopuation = countryPopulation;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryPopuation() {
		return countryPopuation;
	}

	public void setCountryPopuation(String countryPopuation) {
		this.countryPopuation = countryPopuation;
	}

	public Collection<State> getStates() {
		return states;
	}

	public void setStates(Collection<State> states) {
		this.states = states;
	}

	public Capital getCapital() {
		return capital;
	}

	public void setCapital(Capital capital) {
		this.capital = capital;
	}

	public Collection<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(Collection<Language> languages) {
		this.languages = languages;
	}

}
