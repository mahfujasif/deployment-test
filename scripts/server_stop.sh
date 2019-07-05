#!/usr/bin/env bash

PID=$(pgrep java)
if [ -z "$PID" ]
then
    echo 'Application is already stopped.'
    exit 0
fi

sudo /usr/local/bin/supervisorctl stop deployment-test
