# Containerize SpringBoot Application

SpringBoot let us to create stand alone lightweight web application component in a microservice architecture.

By Containerizing using Docker, the application can be build and deployed anywhere.

## Description
Here we're gonna containerize the SpringBoot Application using docker.

## Prerequisite
1. Setup Docker, Java, Maven and Git in to your local machine.
2. Clone the repository.

## How to test?
From root directory of the project
<br>1. Build the SpringBoot application
````
mvn clean install
````
<br>2. Build docker image
````
docker build -t myapp:1.0 .
````
<br>3. Deploy image on to docker container
````
docker run -d -p 8080:8080 myapp:1.0
````
<br>4. Validate from browser
<br>launch `http:localhost:8080/` then you should be able to see message `Welcome To Dockerized SpringBoot Application!`