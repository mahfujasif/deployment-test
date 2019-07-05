#!/usr/bin/env bash

while [ true ]
do
    if [ "$(curl -s http://localhost:8080/health-check)" = '{"message":"Current API version for deployment-test: 1"}' ]
    then
        exit 0
    fi

    echo 'Check server is running?'
    sleep 5
done
