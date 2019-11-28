package com.api;

import com.api.*;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class UserApiApplication extends Application<UserApiConfig> {

	public static void main(String[] args) throws Exception {
		new UserApiApplication().run(args);
	}

	@Override
	public void run(UserApiConfig configuration, Environment environment) throws Exception {
		final UserApiResource resource = new UserApiResource();

		environment.jersey().register(resource);
	}

}
