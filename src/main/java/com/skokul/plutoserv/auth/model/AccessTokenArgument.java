package com.skokul.plutoserv.auth.model;

public class AccessTokenArgument {

	private String email;

	// For Mapping JSON to Java Object
	public AccessTokenArgument() {
	}

	public AccessTokenArgument(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
