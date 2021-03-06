// Usman Sattar - G00345816
// Part 2 - RESTful User Account Service

package com.client;

// Imports
import com.grpcproject.User.APIResponse;
import com.grpcproject.User.LoginRequest;
import com.grpcproject.userGrpc;
import com.grpcproject.userGrpc.userBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

	public static void main(String[] args) {

		// Creating User ID
		String userID = "G00345816";
		// Creating Password for User to login
		String password = "G00345816";

		// Printing User Id and Password
		System.out.println("User ID = " + userID + "\nUser Password = " + password);

		// System.out.println("User id sent = " + user + "\nUser Password sent = " +
		// pass);

		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();

		// stubs - generate from proto
		userBlockingStub userStub = userGrpc.newBlockingStub(channel);

		LoginRequest loginrequest = LoginRequest.newBuilder().setUsername(userID).setPassword(password).build();

		APIResponse response = userStub.login(loginrequest);

		System.out.println(response.getResponsemessage());

	}

}