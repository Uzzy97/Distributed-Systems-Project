// Usman Sattar - G00345816
// Part 2 - RESTful User Account Service

package com.api;

// Imports
import com.fasterxml.jackson.annotation.JsonProperty;

// Variables
public class User {
	int userId;
	String userName;
	String email;
	String password;
	private String hashedPassword;
	private String salt;

	// private static HashMap<Integer, User> usersMap = new HashMap<>();

	// Empty Constructor
	public User() {
		// Needed for Jackson Deserialisation
	}

	// Constructor with userId, userName, email, password
	public User(int userId, String userName, String email, String password) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	// Constructor with hashed and salted password
	public User(int userId, String userName, String email, String hashedPassword, String salt) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.hashedPassword = hashedPassword;
		this.salt = salt;
	}

	// Get method for receiving userId
	@JsonProperty
	public int getUserId() {
		return userId;
	}

	// public static void updateUser(int userId, User user) {
	// usersMap.put(userId, user);
	// }

	// Get method for receiving userName
	@JsonProperty
	public String getUserName() {
		return userName;
	}

	// Set method for userId
	@JsonProperty
	public void setUserId(int userId) {
		this.userId = userId;
	}

	// Get method for receiving user email
	@JsonProperty
	public String getEmail() {
		return email;
	}

	// Get method for receiving password
	@JsonProperty
	public String getPassword() {
		return password;
	}

	// Get method for receiving hashed password
	@JsonProperty
	public String getHashedPassword() {
		return hashedPassword;
	}

	// Set method for hashed password
	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	// Get method for receiving salted password
	@JsonProperty
	public String getSalt() {
		return salt;
	}

	// Set method for salted password
	public void setSalt(String salt) {
		this.salt = salt;
	}

	// String to String Method
	@Override
	public String toString() {
		return "User{" + "userId=" + userId + " userName='" + userName + '\'' + " email='" + email + '\''
				+ " password='" + password + '\'' + " hashedPassword=" + hashedPassword + " salt=" + salt;
	}

}
