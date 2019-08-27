# Multi-Container Application Using Docker Compose

SpringBoot let us to create stand alone lightweight web application component in a microservice architecture. Spring JPA is a ORM framework to do CRUD operation.

By Containerizing using Docker, the application can be build and deployed anywhere.

Docker Compose let us to define and run multi-container docker application. 

## Description
Here we're gonna containerize the SpringBoot and mysql. And using docker networks both isolated containers were linked together to let spring application retrieve data from mysql.

## Prerequisite
1. Setup Docker, Java, Maven and Git in to your local machine.
2. Clone the repository.

## How to test?

1. Build Image
docker-compose build

2. Run Container
docker-compose up

3. Validate<br>
Launch `http:localhost:8080/health` or run curl command `curl -v http://localhost:8080/health` in terminal,then you should be able to see message `All Good!`

Launch `http:localhost:8080/all` or run curl command `curl -v http://localhost:8080/all` in terminal,then you should be able to see `Customer Information`.
