package com.guilherme.starwars;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class StarwarsApplicationTests {

	@Test
	void status200() {
		TestRestTemplate restTemplate = new TestRestTemplate();
		ResponseEntity<String> response = restTemplate
				.getForEntity("http://localhost:8080/api/jdtest/starwars?film_id=1&character_id=2", String.class);
		assertThat(response.getStatusCodeValue() == 200);
	}

	@Test
	void statusOK() {
		TestRestTemplate restTemplate = new TestRestTemplate();
		ResponseEntity<String> response = restTemplate
				.getForEntity("http://localhost:8080/api/jdtest/starwars?film_id=1&character_id=2", String.class);
		assertThat(response.getStatusCode().equals(HttpStatus.OK));
	}

	@Test
	void require() {
		TestRestTemplate restTemplate = new TestRestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/api/jdtest/starwars",
				String.class);
		assertThat(response.getStatusCode().equals(HttpStatus.BAD_REQUEST));
		assertThat(response.getBody().contains("Required int parameter 'film_id' is not present"));
	}

	@Test
	void notFound() {
		TestRestTemplate restTemplate = new TestRestTemplate();
		ResponseEntity<String> response = restTemplate
				.getForEntity("http://localhost:8080/api/jdtest/starwars?film_id=7&character_id=10", String.class);
		assertThat(response.getStatusCode().equals(HttpStatus.NOT_FOUND));
		assertThat(response.getBody().contains("personagens nao encontrados"));
	}

	@Test
	void badRequest() {
		TestRestTemplate restTemplate = new TestRestTemplate();
		ResponseEntity<String> response = restTemplate
				.getForEntity("http://localhost:8080/api/jdtest/starwars?film_id=8&character_id=10", String.class);
		assertThat(response.getStatusCode().equals(HttpStatus.BAD_REQUEST));
		assertThat(response.getBody().contains("personagens nao encontrados"));
	}

	@Test
	void success() {
		TestRestTemplate restTemplate = new TestRestTemplate();
		ResponseEntity<String> response = restTemplate
				.getForEntity("http://localhost:8080/api/jdtest/starwars?film_id=1&character_id=2", String.class);
		assertThat(response.getBody().equals("[\"C-3PO\",\"R2-D2\",\"R5-D4\"]"));
	}

	@Test
	void post() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		TestRestTemplate restTemplate = new TestRestTemplate();

		ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/api/jdtest/starwars",
				HttpMethod.POST, entity, String.class);

		assertThat(response.getStatusCode().equals(HttpStatus.UNAUTHORIZED));
	}

	@Test
	void patch() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		TestRestTemplate restTemplate = new TestRestTemplate();

		String response = restTemplate.patchForObject("http://localhost:8080/api/jdtest/starwars", entity, String.class);


		assertThat(!response.isEmpty());
	}

	@Test
	void delete() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		TestRestTemplate restTemplate = new TestRestTemplate();

		ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/api/jdtest/starwars",
				HttpMethod.DELETE, entity, String.class);

		assertThat(response.getStatusCode().equals(HttpStatus.UNAUTHORIZED));
	}
}
