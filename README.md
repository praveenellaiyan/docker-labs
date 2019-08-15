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

<h4>Help Commands</h4>

list all docker commands related to image like push, pull, remove etc.
````
docker image --help
````
list all docker commands related to container like run, stop, kill list etc.
````
docker container --help
````

<h4>Image Specific</h4>

inspect Dockerfile from application root directory and build an image
````
docker build .
````
build image and add tag along with version to it.
````
docker build -t <tag-name>:<version>
````
returns information about image in json notation.
````
docker image inspect <tag-name>
````
list all images in docker host.
````
docker image ls
````
remove image either by id or with corresponding tag name and version mapped.
````
docker image rm <image-id>
docker image rm <tag-name>:<version>
````

<h4>Container Specific</h4>

run = create + start
launch instance of an image.
````
docker run <image-name> -d
````
launch instance of an image and override the default command. The flag `-d` run container in background.
````
docker run <image-name> <command>
````
start container and stream output from container on to the terminal.
````
docker start -a <container-id>
````
start container and map host port with container port using flag `-p`.
It then pass environment varibale using `-e` flag.
And finally name the container using flag `--name`.
````
docker container run -it -p <host-port>:<container-port> -e <key:value> <image-name> --name <container-name>
````
list all running containers.
````
docker ps
````
list all containers created ever from an machine.
````
docker ps --all
````
returns memory utilization, bandwidth, cpu usage and real time metrics.
````
docker container stats
````
execute another command inside a container.
-i – lets user to input command.
-t – to opt in for interactive terminal.
````
docker exec -it <container-id> <command>
````
allows user to enter into container and execute bash commands.
````
docker exec -it <container-id> sh
docker exec -it <container-id> bash
````
print logs from the container.
````
docker logs <container-id>
````
run custom scripts when container starts
````
ENTRYPOINT ["<script-file-to-execute>"]
````
<h6>Contrast between ENTRYPOINT and CMD</h6>

`CMD` lets pass param to entrypoint and also can be used to set default command to execute on container start. CMD containing bash commands were executed from `/bin/sh -c`
<br>Whereas `ENTRYPOINT` allows to run script when container start. Default ENTRYPOINT is `/bin/sh -c`.

stop container and do some clean up stuff.
````
docker stop <container-id>
````
stop container instantly.
````
docker kill <container-id>
````
list stopped containers.
````
docker container -a
````

<h4>Volume Specific</h4>

Create volume
````
docker volume create <volume-name>
````
<h5>Sharing data between containers</h5>

Map volume on to container by adding flag `-v`
````
-v <named-volume-name>:<directory name to restore data from>
````
Expose directory that contains data to other containers by below flag on running containers.
````
-v <expose-directory-path>
````
Get exposed data from containers using volumes by adding below flag
````
--volumes-from <container-name>
````
Mount directory from host os on to container by adding flag below
````
-v <directory-from-host-os>:<directory inside container>
````
<h4>Network specific</h4>

list down networks
````
docker network ls
````
display docker network information
````
docker network inspect bridge
````
display network details of an image
````
docker exec <image> ifconfig
````
create docker network
````
docker network create --driver bridge <network-name>
````
Map containers to docker network by using below flag
````
--net <network-name>
````
<h4>Docker compose specific</h4>

run services that has build property and build images.
````
docker-compose build
````
run services that has image property and pull image if not exist in cache.
````
docker-compose pull
````
start services mentioned in `docker-compose.yml`.
````
docker-compose up
````
All in one command that does pull an image, build an image and run it in container.
````
docker-compose up --build -d
````
restart all services
````
docker-compose restart
````
restart specific service from docker compose
````
docker-compose restart <service-name>
````
remove all stopped containers which are launched using docker compose
````
docker-compose rm
````

<h4>Optimize docker image</h4>

It is vital to keep the image built least sufficient enough to launch application. In real time large scale application the impact of optimizing an image plays a cruial role.
<br>`.dockerignore` file is pretty much similar to .gitignore file which contains pattern to exclude files which aren't required on build.

<h4>Docker handle failover mechanism</h4>

flag helps to automatically restart container if at all crash/failure happens.
````
--restart on-failure
````

<h4>Clean-up Command</h4>

remove all stopped containers and dangling images.
````
docker system prune
````
