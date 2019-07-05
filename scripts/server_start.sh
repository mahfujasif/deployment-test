#!/usr/bin/env bash

cd /opt/deployment-test/target
/usr/bin/java -jar *.jar >> ~/api.log 2>&1 &
exit 0
