import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import user.UserService;

public class GrpcServer {

	 public static void main(String args[]) throws IOException, InterruptedException {
		 
		 
		 //// encryption method hash
		 String password = "G00345816";
		 System.out.println("Password check " + password);
		 System.out.println("MD5 " + Encryption.hash(password));
		//////////////////
		 
		 //// encryption method Salt //
		 System.out.println("SALT " + Encryption.salt(password));
		
		 //////////////////
		 /// server starting //
		 System.out.println("=======================\n\nstarting GRPC Server");
		 Server server = ServerBuilder.forPort(9090).addService(

				 new UserService()).build();
		 
		 server.start();
		 System.out.println("server started at "+ server.getPort());
	        server.awaitTermination();
	 }
	 
	 ///// server finished code //
	 
	 
}