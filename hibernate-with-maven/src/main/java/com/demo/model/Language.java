package com.demo.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name = "LANGUAGE")
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LANGUAGE_ID")
	private Integer langageId;
	
	@Column(name = "LANGUAGE_NAME")
	private String languageName;
	
	@ManyToMany(mappedBy = "languages")
	private Collection<Country> countries = new ArrayList<Country>();

	public Language() {
		super();
	}
	
	public Language(String languageName) {
		this.languageName = languageName;
	}
	
	public Integer getLangageId() {
		return langageId;
	}

	public void setLangageId(Integer langageId) {
		this.langageId = langageId;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	@Override
	public String toString() {
		return "Language [langageId=" + langageId + ", languageName=" + languageName + ", countries=" + countries + "]";
	}

}
