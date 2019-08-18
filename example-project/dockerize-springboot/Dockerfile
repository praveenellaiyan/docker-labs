# use base image as openjdk
FROM openjdk:8-jdk-alpine

# pass argument 'WORKSPACE' during build
ARG WORKSPACE="/app"

# run shell script to create directory
RUN mkdir ${WORKSPACE}

# set path and followed by instruction will be executed underneath it
WORKDIR ${WORKSPACE}

# copy java package on to destination 'WORKSPACE'
COPY target/*.jar ${WORKSPACE}/app.jar

# expose container port 8080
EXPOSE 8080

# default command to be executed when container starts
CMD ["java","-jar","app.jar"]