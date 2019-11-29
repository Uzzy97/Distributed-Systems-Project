// Usman Sattar - G00345816
// Part 2 - RESTful User Account Service

package com.api;

// Imports
import com.codahale.metrics.health.HealthCheck;

// ExampleHealthCheck extends HealthCheck
public class ExampleHealthCheck extends HealthCheck {
	// Checking Results
	@Override
	protected Result check() throws Exception {
		return Result.healthy();
	}

}
