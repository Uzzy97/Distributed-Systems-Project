package com.user;

import com.grpcproject.User.APIResponse;
import com.grpcproject.User.LoginRequest;
import com.grpcproject.userGrpc.userImplBase;
import com.server.Encryption;

import io.grpc.stub.StreamObserver;

public class UserService extends userImplBase {

	@Override
	public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {

		System.out.println("Login Verified");

		String username = request.getUsername();
		String password = request.getPassword();

		System.out.println("\nClient Username: " + request.getUsername());
		System.out.println("Client Password: " + request.getPassword());
		System.out.println("*************************************************************");
		System.out.println("Hashed Username: " + Encryption.hash(username));
		System.out.println("Salted Password: " + Encryption.salt(password));

		// Connecting via API
		APIResponse.Builder response = APIResponse.newBuilder();
		if (username.equals(password)) {

			// Returning message for successful login
			response.setResponseCode(0).setResponsemessage("Login Successful");

		} else {
			// Returning message for invalid password
			response.setResponseCode(100).setResponsemessage("Invalid Login");
		}
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}
}
