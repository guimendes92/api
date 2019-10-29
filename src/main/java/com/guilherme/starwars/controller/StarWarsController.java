package com.guilherme.starwars.controller;

import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guilherme.starwars.model.ErrorMessage;
import com.guilherme.starwars.model.Message;
import com.guilherme.starwars.service.StarWarsService;

@RestController
@RequestMapping("/starwars")
public class StarWarsController {

	private StarWarsService service = new StarWarsService();

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getCharaters(@RequestParam("film_id") int filmId,
			@RequestParam("character_id") int characterId) {
		try {
			List<String> characters = service.getCharater("1");

			return !characters.isEmpty() ? new ResponseEntity<List<String>>(characters, HttpStatus.OK)
					: new ResponseEntity<ErrorMessage>(new ErrorMessage(Message.NOT_FOUND.getMessage()),
							HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<ErrorMessage>(new ErrorMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createCharater() {
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(Message.UNAUTHORIZED.getMessage()),
				HttpStatus.UNAUTHORIZED);
	}

	@PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateCharater() {
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(Message.UNAUTHORIZED.getMessage()),
				HttpStatus.UNAUTHORIZED);
	}

	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteCharacter() {
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(Message.UNAUTHORIZED.getMessage()),
				HttpStatus.UNAUTHORIZED);
	}

	@RequestMapping(method = RequestMethod.OPTIONS)
	public ResponseEntity<?> optionsController() {
		return ResponseEntity.ok().allow(HttpMethod.GET, HttpMethod.OPTIONS).build();
	}
}