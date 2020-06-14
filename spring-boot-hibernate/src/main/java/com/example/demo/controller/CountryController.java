package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Country;
import com.example.demo.service.CountryService;

@RestController
public class CountryController {

	@Autowired
	private CountryService countryService;

	@GetMapping(value = "/getAllCountries")
	public List<Country> getCountries() {
		return countryService.getAllCountries();
	}

	@GetMapping(value = "/getCountry/{id}")
	public Country getCountryById(@PathVariable int id) {
		return countryService.getCountry(id);
	}

	@PostMapping(value = "/addCountry")
	public void addCountry(@RequestBody Country country) {
		countryService.addCountry(country);

	}

	@PutMapping(value = "/updateCountry")
	public void updateCountry(@RequestBody Country country) {
		countryService.updateCountry(country);
	}

	@DeleteMapping(value = "/deleteCountry/{id}")
	public void deleteCountry(@PathVariable("id") int id) {
		countryService.deleteCountry(id);
	}
}