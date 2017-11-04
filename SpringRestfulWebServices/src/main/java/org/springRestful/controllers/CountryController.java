
package org.springRestful.controllers;

import java.util.List;

import org.springRestful.beans.Country;
import org.springRestful.services.CountryService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
	CountryService countryService = new CountryService();

	@RequestMapping(value="/countries", method = RequestMethod.GET, headers="Accept=application/json")
	public List<Country> getCountries(){
		return countryService.getCountries();
	}

	@RequestMapping(value="/country/{id}", method = RequestMethod.GET, headers="Accept=application/json")
	public Country getCountryById(@PathVariable int id){
		Country country = countryService.getCountryById(id);
		return country;
	}

	@RequestMapping(value="/addCountry", method = RequestMethod.POST, headers="Accept=application/json")
	public Country addCountry(@RequestBody Country country)
	{
		return countryService.addCountry(country);
	}

	@RequestMapping(value="/updateCountry", method = RequestMethod.PUT, headers="Accept=application/json")
	public Country updateCountry(@RequestBody Country country)
	{
		return countryService.updateCountry(country);

	}

	@RequestMapping(value="/country/{id}", method = RequestMethod.DELETE, headers="Accept=application/json")
	public void deleteCountry(@PathVariable int id)
	{
		countryService.deleteCountry(id);

	}
}
