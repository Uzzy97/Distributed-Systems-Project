package com.api.user;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	int userId;
	String userName;
	String email;
	String password;
	
	private static HashMap<Integer, User> usersMap = new HashMap<>();
	
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
	public void setUserId(int userId) {
		this.userId = userId ;
	}
	
	public static void updateUser(int userId, User user){
		usersMap.put(userId, user);
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
