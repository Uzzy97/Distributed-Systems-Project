# Distributed-Systems-Project
The purpose of this project is to gain practical experience in interprocess communication protocols used in modern distributed systems.

### Instructions To Run The Server

* Download "your-service.jar" file to your desktop.
* Open CMD and direct it to your desktop.

* **Run the following code _"java -jar your-service.jar"_ in order to run the jar file**

### Instructions To Run The Client In Order To Test The Server

* Download "GrpcClient.java" from this repository.
* Run "GrpcClient.java" in eclipse.

* **Run the following code _"java -jar your-service.jar"_ in order to run the server jar file first**
* **Go to eclipse and run _"GrpcClient.java"_ in order to see the client connecting to the server**

## Part 2 - RESTful User Account Service

* Clone repository on to desktop (**git clone _"https://github.com/Uzzy97/Distributed-Systems-Project.git"_**)
* Open **grpcClient** folder
* Open Command Prompt and Run **grpcClient-0.0.1-SNAPSHOT** by the following command **_"java -jar grpcClient-0.0.1-SNAPSHOT.jar server userApiConfig.yaml"_**
* Open Browser **_"http://localhost:9000/users"_** in order to run the userApiApplication and view all the users created
* Open _"Postman"_ while browser is running
* Add **New Users**, **Delete Existing Users**, **Update Existing Users**, **Get All Users**
* The above changes can be viewed on the **_"http://localhost:9000/users"_**, individual users can be viewed also.
* For Example **_"http://localhost:9000/users/2"_**
