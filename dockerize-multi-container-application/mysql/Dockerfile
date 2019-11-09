# use base image as mysql latest version
FROM mysql

# set environmental variables
ENV MYSQL_DATABASE multicontainerdb
ENV MYSQL_ROOT_PASSWORD=tiger

# copy sql file which needs to be executed when container starts
COPY mysql-init.sql /docker-entrypoint-initdb.d/
