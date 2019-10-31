package server;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import user.UserService;

public class GrpcServer {

	public static void main(String args[]) throws IOException, InterruptedException {

		// Hash - Encryption Method
		String password = "G00345816";
		System.out.println("\n\nVerifying Password: " + password);
		System.out.println("Hashed Username: " + Encryption.hash(password));

		// Salt - Encryption Method
		System.out.println("Salted Password: " + Encryption.salt(password));

		// Starting GRPC Server...
		System.out.println("***************************************************************");
		System.out.println("\nstarting GRPC Server");
		Server server = ServerBuilder.forPort(9090).addService(

				new UserService()).build();

		server.start();
		System.out.println("server started at " + server.getPort());
		server.awaitTermination();
	}
}