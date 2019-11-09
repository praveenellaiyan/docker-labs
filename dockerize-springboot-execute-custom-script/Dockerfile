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

# copy script to execute on to destination 'WORKSPACE'
COPY custom-script.sh ${WORKSPACE}/custom-script.sh

# change permission of the script so that it is executable inside container
RUN chmod +x ${WORKSPACE}/custom-script.sh

# expose container port 8080
EXPOSE 8080

# using entrypoint either we can give command to execute or we can pass script file to execute
ENTRYPOINT ["sh","custom-script.sh"]
