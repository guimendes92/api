package com.guilherme.starwars.model;

public enum Message {

	NOT_FOUND("personagens nao encontrados"),
	ERROR("nao foi possivel retornar os personagens"),
	UNAUTHORIZED("nao autorizado"),
	BAD_REQUEST("nao foi possivel fazer a conexao");

	private String message;
	
	Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}