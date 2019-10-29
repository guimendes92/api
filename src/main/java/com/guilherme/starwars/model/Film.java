package com.guilherme.starwars.model;

import java.util.List;

public class Film {

	private String title;
	private String episode_id;
	private String opening_crawl;
	private String director;
	private String producer;
	private String release_date;
	private List<String> characters;
	private List<String> planets;
	private List<String> starships;
	private List<String> vehicles;
	private List<String> species;
	private String created;
	private String edited;
	private String url;

	public Film() {
	}

	public Film(String title, String episode_id, String opening_crawl, String director, String producer,
			String release_date, List<String> characters, List<String> planets, List<String> starships,
			List<String> vehicles, List<String> species, String created, String edited, String url) {
		this.title = title;
		this.episode_id = episode_id;
		this.opening_crawl = opening_crawl;
		this.director = director;
		this.producer = producer;
		this.release_date = release_date;
		this.characters = characters;
		this.planets = planets;
		this.starships = starships;
		this.vehicles = vehicles;
		this.species = species;
		this.created = created;
		this.edited = edited;
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEpisode_id() {
		return episode_id;
	}

	public void setEpisode_id(String episode_id) {
		this.episode_id = episode_id;
	}

	public String getOpening_crawl() {
		return opening_crawl;
	}

	public void setOpening_crawl(String opening_crawl) {
		this.opening_crawl = opening_crawl;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public List<String> getCharacters() {
		return characters;
	}

	public void setCharacters(List<String> characters) {
		this.characters = characters;
	}

	public List<String> getPlanets() {
		return planets;
	}

	public void setPlanets(List<String> planets) {
		this.planets = planets;
	}

	public List<String> getStarships() {
		return starships;
	}

	public void setStarships(List<String> starships) {
		this.starships = starships;
	}

	public List<String> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<String> vehicles) {
		this.vehicles = vehicles;
	}

	public List<String> getSpecies() {
		return species;
	}

	public void setSpecies(List<String> species) {
		this.species = species;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getEdited() {
		return edited;
	}

	public void setEdited(String edited) {
		this.edited = edited;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}

/*
 * {"title":"A New Hope", "episode_id":4,
 * "opening_crawl":"It is a period of civil war.\r\nRebel spaceships, striking\r\nfrom a hidden base, have won\r\ntheir first victory against\r\nthe evil Galactic Empire.\r\n\r\nDuring the battle, Rebel\r\nspies managed to steal secret\r\nplans to the Empire's\r\nultimate weapon, the DEATH\r\nSTAR, an armored space\r\nstation with enough power\r\nto destroy an entire planet.\r\n\r\nPursued by the Empire's\r\nsinister agents, Princess\r\nLeia races home aboard her\r\nstarship, custodian of the\r\nstolen plans that can save her\r\npeople and restore\r\nfreedom to the galaxy...."
 * , "director":"George Lucas", "producer":"Gary Kurtz, Rick McCallum",
 * "release_date":"1977-05-25", "characters":["https://swapi.co/api/people/1/",
 * "https://swapi.co/api/people/2/","https://swapi.co/api/people/3/",
 * "https://swapi.co/api/people/4/","https://swapi.co/api/people/5/",
 * "https://swapi.co/api/people/6/","https://swapi.co/api/people/7/",
 * "https://swapi.co/api/people/8/","https://swapi.co/api/people/9/",
 * "https://swapi.co/api/people/10/","https://swapi.co/api/people/12/",
 * "https://swapi.co/api/people/13/","https://swapi.co/api/people/14/",
 * "https://swapi.co/api/people/15/","https://swapi.co/api/people/16/",
 * "https://swapi.co/api/people/18/","https://swapi.co/api/people/19/",
 * "https://swapi.co/api/people/81/"],
 * "planets":["https://swapi.co/api/planets/2/",
 * "https://swapi.co/api/planets/3/","https://swapi.co/api/planets/1/"],
 * "starships":["https://swapi.co/api/starships/2/",
 * "https://swapi.co/api/starships/3/","https://swapi.co/api/starships/5/",
 * "https://swapi.co/api/starships/9/","https://swapi.co/api/starships/10/",
 * "https://swapi.co/api/starships/11/","https://swapi.co/api/starships/12/",
 * "https://swapi.co/api/starships/13/"],
 * "vehicles":["https://swapi.co/api/vehicles/4/",
 * "https://swapi.co/api/vehicles/6/","https://swapi.co/api/vehicles/7/",
 * "https://swapi.co/api/vehicles/8/"],
 * "species":["https://swapi.co/api/species/5/",
 * "https://swapi.co/api/species/3/","https://swapi.co/api/species/2/",
 * "https://swapi.co/api/species/1/","https://swapi.co/api/species/4/"],
 * "created":"2014-12-10T14:23:31.880000Z",
 * "edited":"2015-04-11T09:46:52.774897Z",
 * "url":"https://swapi.co/api/films/1/"}
 */