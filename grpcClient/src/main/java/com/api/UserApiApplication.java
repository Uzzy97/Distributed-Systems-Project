// Usman Sattar - G00345816
// Part 2 - RESTful User Account Service

package com.api;

// Imports
import com.api.*;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

// UserApiApplication extends Application<UserApiConfig>
public class UserApiApplication extends Application<UserApiConfig> {

	// Main Method
	public static void main(String[] args) throws Exception {
		new UserApiApplication().run(args);
	}

	// Run Method
	@Override
	public void run(UserApiConfig configuration, Environment environment) throws Exception {

		// Health Check
		final ExampleHealthCheck healthCheck = new ExampleHealthCheck();
		final UserApiResource resource = new UserApiResource();
		environment.healthChecks().register("example", healthCheck);
		environment.jersey().register(resource);
	}

}
