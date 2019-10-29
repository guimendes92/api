package com.guilherme.starwars.model;

public enum Message {

	NOT_FOUND("personagens nao encontrados"),
	MESSAGE("mensagem"),
	UNAUTHORIZED("nao autorizado"),
	BAD_REQUEST("nao foi possivel retornar os personagens");

	private String message;
	
	Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}