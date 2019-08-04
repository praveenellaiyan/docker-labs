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

### Image:
``
A Docker Image is an single executable package which includes everything needed to run an application i.e. the code, libraries, runtime, environment variables and configuration files. The base image contains configurations, setting environmental variables, integrating/configuring specific monitoring tools and installing packages/dependencies to make your application docker image as lightweight as possible.
``
### Container:
``
Container is an running instance of an docker image. Containers are isolated from each other and has its own hardware and process setup. All containers run in world of linux irrespective of host operating system.
``

![Image Container](https://user-images.githubusercontent.com/36845597/62424285-78650680-b6ea-11e9-8067-fc2e656cd59f.PNG)

### Docker Client:
``
Docker client takes the command from terminal and pass it to docker host/server where docker daemon in running. Also it stream the output from docker server on to the terminal.
``
### Docker Daemon:
``
It is a service running on host operating system which is responsible for execute the command from the client like manipulating lifecycle of containers, build/push/pull images from/to docker hub and many more.
``
<br><h4>Moreover Docker follows client and server architecture.</h4>
![Docker Client   Server Arch](https://user-images.githubusercontent.com/36845597/62424480-81ef6e00-b6ec-11e9-8efc-e1d28d42b383.PNG)
