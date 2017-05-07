#!/bin/bash

docker-machine status development >& /dev/null
if [ $? -ne 1 ]; then
    docker-machine create --driver virtualbox development
    eval "$(docker-machine env development)"
    docker-machine start development
fi

if [ $# -ne 1 ]; then
    echo "[WARNING] One argument is required to execute." 1>&2
    echo "sh $0 (product | development)"
    exit 1
fi
eval "$(docker-machine env development)"

# make jar file
mvn clean package -Dmaven.test.skip=true

# deploy janaf-web.jar
docker build -t y-ok/janaf-web ./

# start janaf-web
docker-compose up $1