package com.api;

import javax.ws.rs.core.Response.Status;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.HashMap;
import javax.ws.rs.*;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserApiResource {
	ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();

	public UserApiResource() {

		usersMap.put(testUser.getUserId(), testUser);
		usersMap.put(testUser1.getUserId(), testUser1);
	}

	private HashMap<Integer, User> usersMap = new HashMap<>();
	User newuser;
	User testUser = new User(1, "John", "JohnMurphy@gmail.com", "1234");
	User testUser1 = new User(2, "Usman", "UsmanSattar@gmail.com", "54545");

	@GET
	public Collection<User> getUsers() {

		return usersMap.values();
	}

	@GET
	@Path("/{userId}")
	public Response getUserByUserId(@PathParam("userId") int id) throws Exception {
		User user = usersMap.get(id);

		if (user != null)
			return Response.ok(user).build();
		else
			return Response.status(Status.OK).build();

	}

	// creating new user and returning the collections with new user//
	@POST
	public Response newUser(User user) throws Exception {

		int id = usersMap.size() + 1;

		user.setUserId(id);

		String usernew = String.valueOf(user.getUserId());

		usersMap.put(id, user);

		return Response.created(new URI("/users/" + usernew)).entity(usersMap.get(user.getUserId()))
				.status(Status.CREATED).build();

	}

	@PUT
	@Path("/{userId}")
	public Response updateUser(@PathParam("userId") int id, User user) throws Exception {

		newuser = user;

		newuser.setUserId(id);

		usersMap.replace(id, user);

		return Response.status(Status.OK).entity(usersMap.get(id)).build();
	}

	@DELETE
	@Path("/{userId}")
	public Response removeUserByUserId(@PathParam("userId") int id) throws Exception{
		if(id == usersMap.get(id).getUserId()) {
			usersMap.remove(id);
			return Response.ok(usersMap.values()).build();
		} else {
		
			return Response.status(Status.OK).entity(usersMap.get(id)).build();

		}
	}
}
