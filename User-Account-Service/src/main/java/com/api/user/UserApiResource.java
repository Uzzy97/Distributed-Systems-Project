package com.api.user;

import java.net.URI;
import javax.ws.rs.core.Response.Status;
import java.util.Collection;
import java.util.HashMap;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserApiResource {



	//public UserApiResource() {
//
	//	usersMap.put(testUser.getUserId(), testUser);
		//usersMap.put(testUser1.getUserId(), testUser1);
	//}

	public UserApiResource() {
		
		usersMap.put(testUser.getUserId(), testUser);
		usersMap.put(testUser1.getUserId(), testUser1);
	}

	private HashMap<Integer, User> usersMap = new HashMap<>();
	User newuser;
	User testUser = new User(1, "John", "JohnMurphy@gmail.com", "1234");
	User testUser1 = new User(2, "Arek", "Arek@gmail.com", "54545");

	// public UserApiResource() {
	// usersMap.put(testUser.getUserId(), testUser);
	// }

	@GET
	public Collection<User> getUsers() {
		// artistsMap.values() returns Collection<Artist>
		// Collection is the interface implemented by Java collections like ArrayList,
		// LinkedList etc.
		// it's basically a generic list.
		// https://docs.oracle.com/javase/7/docs/api/java/util/Collection.html

		return usersMap.values();
	}

	@GET
	@Path("/{userId}")
	public Response getUserByUserId(@PathParam("userId") int id)throws Exception {
		User user = usersMap.get(id);

		// EmployeeDB.getEmployee(id);
		if (user != null)
			return Response.ok(user).build();
		else
			return Response.status(Status.OK).build();

	}
	
	// creating new user and returning the collections with new user//
		@POST
		public Response newUser(User user) throws Exception {
					
			int id = usersMap.size()+1;
			
			user.setUserId(id);
			
			String usernew = String.valueOf(user.getUserId());
			
			usersMap.put(id, user);
		
			return Response.created(new URI("/users/" + usernew)).entity(usersMap.get(user.getUserId())).status(Status.CREATED).build();

		}
	
	/*@POST
    public Response createUser(User user, int id) throws URISyntaxException {
        // validation
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        user = usersMap.get(id);
       // Employee e = EmployeeDB.getEmployee(employee.getId());
        if (violations.size() > 0) {
            ArrayList<String> validationMessages = new ArrayList<String>();
            for (ConstraintViolation<User> violation : violations) {
                validationMessages.add(violation.getPropertyPath().toString() + ": " + violation.getMessage());
            }
            return Response.status(Status.BAD_REQUEST).entity(validationMessages).build();
        }
        if (user != null) {
        	User.updateUser(user.getUserId(), user);
            return Response.created(new URI("/users/" + user.getUserId()))
                    .build();
        } else
            return Response.status(Status.NOT_FOUND).build();
    }*/

	/*@POST
	public Response createUser(User user) throws URISyntaxException {
		// validation
		Set<ConstraintViolation<User>> violations = validator.validate(user);
		User e = usersMap.get(user.getUserId());
		//User e = usersMap.get(user.userId);
		if (violations.size() > 0) {
			ArrayList<String> validationMessages = new ArrayList<String>();
			for (ConstraintViolation<User> violation : violations) {
				validationMessages.add(violation.getPropertyPath().toString() + ": " + violation.getMessage());
			}
			return Response.status(Status.OK).entity(validationMessages).build();
		}
		if (e != null) {
			User.updateUser(user.getUserId(), user);
			return Response.created(new URI("/users/" + user.getUserId())).build();
		} else
			return Response.status(Status.OK).build();
	}*/
	

	@PUT
	@Path("/{userId}")
	public Response updateUser(@PathParam("userId")int id, User user) throws Exception {
		
		newuser = user;
		
		newuser.setUserId(id);
		
		usersMap.replace(id, user);
			
		return Response.status(Status.OK).entity(usersMap.get(id)).build();
	}
	

	@DELETE
	@Path("/{userId}")
	public Response removeUserByUserId(@PathParam("userId") Integer id) {
		User user = usersMap.get(id);
		if (user != null) {
			usersMap.remove(id);
			return Response.ok().build();
		} else
			return Response.status(Status.OK).build();
	}
}
