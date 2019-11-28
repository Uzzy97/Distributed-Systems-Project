package com.api;

import java.util.Collection;
import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;



@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserApiResource {

	private HashMap<Integer, User> usersMap = new HashMap<>();

	User testUser = new User(1, "John", "John.Murphy@gmail.com", "12345");
	usersMap.put(testUser.getUserId(),testUser);
	
	public UserApiResource() {
	
	}
	@GET
	public Collection<User> getUsers() {
		// artistsMap.values() returns Collection<Artist>
		// Collection is the interface implemented by Java collections like ArrayList,
		// LinkedList etc.
		// it's basically a generic list.
		// https://docs.oracle.com/javase/7/docs/api/java/util/Collection.html

		return usersMap.values();
	}
}
