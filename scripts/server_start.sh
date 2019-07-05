#!/usr/bin/env bash

PID=$(pgrep java)
if [ -n "$PID" ]
then
    echo 'Application is already running. Please stop it before starting.'
    exit 1
fi

sudo /usr/local/bin/supervisorctl start deployment-test
