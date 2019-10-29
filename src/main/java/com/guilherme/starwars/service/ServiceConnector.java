package com.guilherme.starwars.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.guilherme.starwars.model.Message;

public class ServiceConnector {

	public String connect(int id, String controller) throws Exception {
		try {
			URL url = new URL("https://swapi.co/api/" + controller + "/" + id + "/?format=json");
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
				con.disconnect();

				return content.toString();
			} else if (code == 404) {
				con.disconnect();
				throw new Exception(Message.NOT_FOUND.getMessage());
			} else {
				con.disconnect();
				throw new Exception(Message.ERROR.getMessage());
			}
		} catch (MalformedURLException e) {
			throw new Exception(Message.BAD_REQUEST.getMessage());
		} catch (IOException e) {
			throw new Exception(Message.BAD_REQUEST.getMessage());
		}
	}

	public String connect(String address) throws Exception {
		try {
			URL url = new URL(address + "?format=json");
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
				con.disconnect();

				return content.toString();
			} else if (code == 404) {
				con.disconnect();
				throw new Exception(Message.NOT_FOUND.getMessage());
			} else {
				con.disconnect();
				throw new Exception(Message.ERROR.getMessage());
			}
		} catch (MalformedURLException e) {
			throw new Exception(Message.BAD_REQUEST.getMessage());
		} catch (IOException e) {
			throw new Exception(Message.BAD_REQUEST.getMessage());
		}
	}
}