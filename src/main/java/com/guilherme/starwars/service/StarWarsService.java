package com.guilherme.starwars.service;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guilherme.starwars.model.Film;
import com.guilherme.starwars.model.People;
import com.guilherme.starwars.model.Specie;

public class StarWarsService {

	public List<String> getCharater(int filmId, int characterId) throws Exception {
		People character = getCharacter(characterId);

		Film film = getFilm(filmId);

		Specie specie = getSpecie(character.getSpecies().get(0));

		List<People> peoples = getCharacters(specie.getPeople());

		List<String> characters = new ArrayList<String>();

		if (character.getFilms().contains(film.getUrl())) {
			for (People p : peoples) {
				if (p.getFilms().contains(film.getUrl())) {
					characters.add(p.getName());
				}
			}
		}

		return characters;
	}

	private People getCharacter(int id) throws Exception {
		ServiceConnector connector = new ServiceConnector();
		String p = connector.connect(id, "people");

		People people = new ObjectMapper().readValue(p, People.class);

		return people;
	}

	private Film getFilm(int id) throws Exception {
		ServiceConnector connector = new ServiceConnector();
		String f = connector.connect(id, "films");

		Film film = new ObjectMapper().readValue(f, Film.class);

		return film;
	}

	private Specie getSpecie(String url) throws Exception {
		ServiceConnector connector = new ServiceConnector();
		String s = connector.connect(url);

		Specie specie = new ObjectMapper().readValue(s, Specie.class);

		return specie;
	}

	private List<People> getCharacters(List<String> urls) throws Exception {
		List<People> peoples = new ArrayList<People>();

		for (String u : urls) {
			ServiceConnector connector = new ServiceConnector();
			String p = connector.connect(u);

			People people = new ObjectMapper().readValue(p, People.class);

			peoples.add(people);
		}

		return peoples;
	}
}