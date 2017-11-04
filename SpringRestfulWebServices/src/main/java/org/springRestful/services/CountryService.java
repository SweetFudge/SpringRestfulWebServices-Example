package org.springRestful.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springRestful.beans.Country;

public class CountryService {

	private static  List<Country> countries;
	
	public CountryService() {
		if(countries == null){
			countries = createListCountries();
		}
	}
	
	public List<Country> getCountries(){
		return countries;
		
	}
	
	public Country getCountryById(int id){
		
		Optional<Country> countryRes = countries.stream().filter(u -> u.getId() == id).findFirst();
		Country country = (Country)countryRes.orElse(null);
		return country;
	}
	
	public Country addCountry(Country country){
		countries.add(country);
		return country;
	}
	
	public Country updateCountry(Country country){
		countries = countries.stream().map(o -> {if(o.getId() == country.getId())
		{return country;}
		else{return o;}}).collect(Collectors.toList());
		return country;

	}
	
	public void deleteCountry(int id){
		countries = countries.stream().filter(o -> o.getId() != id).collect(Collectors.toList());
	}
	
	
	private List<Country> createListCountries(){
		List<Country> countries = new ArrayList<Country>();
		countries.add(new Country(1,"Suisse",6000000));
		countries.add(new Country(2,"France",60000000));
		countries.add(new Country(3,"Italie",40000000));
		countries.add(new Country(4,"USA",360000000));
		countries.add(new Country(5,"Espagne",35000000));
		countries.add(new Country(6,"Allemagne",5000000));
		countries.add(new Country(7,"Portugal",35000000));
		
		return countries;
		
	}

}
