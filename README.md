# DOCKER

## Why Docker?
Docker let us to containerize the application. Which is then easy to install without worrying the initial setup and depedencies across different platform. Let us to create portable web application: Build Once and deploy anywhere.

## What is Docker?
It is a platform for creating/running and managing containers. Containerization ensures application deploy quickly, reliable and consistent regardless of environment.
````
Before and After Docker
````
![VM   Docker Contrast](https://user-images.githubusercontent.com/36845597/62424532-59b43f00-b6ed-11e9-89e8-91e5fffe67a4.png)

## Docker Terminologies

### Image
A Docker Image is an single executable package which includes everything needed to run an application i.e. the code, libraries, runtime, environment variables and configuration files. The base image contains configurations, setting environmental variables, integrating/configuring specific monitoring tools and installing packages/dependencies to make your application docker image as lightweight as possible.

### Container
Container is an running instance of an docker image. Containers are isolated from each other and has its own hardware and process setup. All containers run in world of linux irrespective of host operating system.

![Image Container](https://user-images.githubusercontent.com/36845597/62424285-78650680-b6ea-11e9-8067-fc2e656cd59f.PNG)

### Docker Client
Docker client takes the command from terminal and pass it to docker host/server where docker daemon in running. Also it stream the output from docker server on to the terminal.

### Docker Daemon
It is a service running on host operating system which is responsible for execute the command from the client like manipulating lifecycle of containers, build/push/pull images from/to docker hub and many more.
<br><h4>Moreover Docker follows client and server architecture.</h4>
![Docker Client   Server Arch](https://user-images.githubusercontent.com/36845597/62424480-81ef6e00-b6ec-11e9-8efc-e1d28d42b383.PNG)

### Docker Volumes
Docker volumes helps to achieve persist data or state of a container on to docker host and support for hot reload of code changes. This can be done through either of the below mentioned method.

> 1. Mount source code of directory from main OS on to the running container.

> 2. Using Named Volume.

### Docker Networks
Docker Networks supports to communicate between containers. Containers are linked together by docker network.<br>
``
Use Case: Let's say we're containerizing the web application. To do so, application server, database, UI components each should be running in a separate docker containers so that it'll be more maintainable and easy to upgrade any of the component independently.
To run the whole application it is must to enable communication between those containers. Here docker network comes to the picture to accomplish this.
``
### Dockerfile
A Dockerfile contains all instruction that docker interpret to build an image.
By default docker expects Dockerfile in root directory of the application. By adding flag `-f <path-to-dockerfile>` lets you to pass path of the dockerfile if it exist in different directory.
<br><b>Sample Dockerfile</b>
````
  // use base image as alpine of latest version
  FROM alpine:latest
  
  // execute shell script to create directory
  RUN mkdir /app
  
  // sets active directory inside a container. Followed by instructions run in workdir.
  WORKDIR /app
  
  // copies files from main os on to docker image.
  COPY <source-files> <destination-path>
  
  // lets to add label to image.
  LABEL <key>=<value>
  
  // lets you to input default command that run when container starts.
  CMD <command>
````
### Docker Compose
Docker Compose helps to launch multi-container application with single `docker-compose.yaml` file.
<br><b>Sample docker-compose.yml </b>
````
# define Docker Compose version
version: '3'

# define list of services to launch
services:

  # service-1
  web:
    build: .
    
  #service-2
  database:
    image: postgres:9.4
    
    # map named volumes to container
    volumes:
      - db-data:/var/lib/postgresql/data
      
# configure volume to persist data
volumes:
  db-data:
````

### Docker Cheat Sheet
````
docker run <image-name>
````
run = create + start
<br>
Command lets you to launch instance of an image.


