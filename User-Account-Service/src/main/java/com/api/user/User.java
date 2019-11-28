package com.api.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	int userId;
	String userName;
	String email;
	String password;
	
	public User() {
        // Needed for Jackson deserialisation
    }
	
	public User(int userId, String userName, String email, String password) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
	
	@JsonProperty
	public int getUserId() {
		return userId;
	}

	@JsonProperty
	public String getUserName() {
		return userName;
	}

	@JsonProperty
	public String getEmail() {
		return email;
	}

	@JsonProperty
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
}
