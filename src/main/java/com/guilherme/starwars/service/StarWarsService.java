package com.guilherme.starwars.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.guilherme.starwars.model.Message;

public class StarWarsService {

	public List<String> getCharater(String id) throws Exception {
		try {
			URL url = new URL("https://swapi.co/api/people/" + id + "/?format=json");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("User-Agent", "swapi");
			con.setRequestMethod("GET");
			int code = con.getResponseCode();

			if (code == 200) {
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				
				String inputLine;
				StringBuffer content = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
				    content.append(inputLine);
				}
				in.close();
				
				List<String> characters = new ArrayList<String>();

				return characters;
			} else {
				con.disconnect();
				throw new Exception(Message.BAD_REQUEST.getMessage());
			}
		} catch (MalformedURLException e) {
			throw new Exception(Message.BAD_REQUEST.getMessage());
		} catch (IOException e) {
			throw new Exception(Message.BAD_REQUEST.getMessage());
		}
	}
}