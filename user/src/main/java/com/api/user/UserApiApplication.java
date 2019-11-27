package com.api.user;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class UserApiApplication extends Application<UserApiConfig> {
	 
	public static void main(String[] args) throws Exception {
	        new UserApiApplication().run(args);
	    }
	
	
	@Override
	public void run(UserApiConfig configuration, Environment environment) throws Exception {
		// TODO Auto-generated method stub
        final UserApiResource resource = new UserApiResource();

        environment.jersey().register(resource);
	}

	
}
