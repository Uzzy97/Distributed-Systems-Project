package com.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	int userId;
	String userName;
	String email;
	String password;
	private String hashedPassword;
	private String salt;
	//private static HashMap<Integer, User> usersMap = new HashMap<>();

	public User() {
		// Needed for Jackson deserialisation
	}

	public User(int userId, String userName, String email, String password) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
	}
	public User(int userId, String userName, String email, String hashedPassword, String salt) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.hashedPassword = hashedPassword;
		this.salt = salt;
	}

	@JsonProperty
	public int getUserId() {
		return userId;
	}

	

	//public static void updateUser(int userId, User user) {
		//usersMap.put(userId, user);
	//}

	@JsonProperty
	public String getUserName() {
		return userName;
	}
	
	@JsonProperty
	public void setUserId(int userId) {
		this.userId = userId;
	}

	@JsonProperty
	public String getEmail() {
		return email;
	}

	@JsonProperty
	public String getPassword() {
		return password;
	}
	@JsonProperty
	public String getHashedPassword() {
		return hashedPassword;
	}
	
	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
	
	@JsonProperty
	public String getSalt() {
		return salt;
	}
	
	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "User{" + "userId=" + userId + " userName='" + userName + '\'' + " email='" + email + '\''
				+ " password='" + password + '\'' + " hashedPassword=" + hashedPassword + " salt=" + salt;
	}

}
