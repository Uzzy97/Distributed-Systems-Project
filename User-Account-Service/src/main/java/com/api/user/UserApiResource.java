package com.api.user;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ch.qos.logback.core.status.Status;



@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserApiResource {

	private HashMap<Integer, User> usersMap = new HashMap<>();
	User testUser = new User(1,"John", "JohnMurphy@gmail.com", "1234");
	User testUser1 = new User(2,"raja", "JohnMurphy@gmail.com", "1234");

	
	//public UserApiResource() {
		//usersMap.put(testUser.getUserId(), testUser);
	//}
	public UserApiResource() {
		
		usersMap.put(testUser.getUserId(),testUser);
		usersMap.put(testUser1.getUserId(),testUser);
	}
	@GET
	public Collection<User> getUser() {
		// artistsMap.values() returns Collection<Artist>
		// Collection is the interface implemented by Java collections like ArrayList,
		// LinkedList etc.
		// it's basically a generic list.
		// https://docs.oracle.com/javase/7/docs/api/java/util/Collection.html

		return usersMap.values();
	}
	
	
	@GET
    @Path("/{userId}")
    public Response getEmployeeById(@PathParam("userId") Integer id) {
        User user = usersMap.get(id);
        		
        		//EmployeeDB.getEmployee(id);
        if (user != null)
            return Response.ok(user).build();
        else
            return Response.status(Status.ERROR).build();
    
	}	
	
}

