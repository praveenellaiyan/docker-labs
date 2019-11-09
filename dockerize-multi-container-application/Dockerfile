# use base image as openjdk
FROM openjdk:8-jdk-alpine

# copy binaries on to image
COPY target/*.jar app.jar

# expose container port 8081
EXPOSE 8081

# using entrypoint either we can give command to execute or we can pass script file to execute
ENTRYPOINT ["java","-jar", "app.jar"]
