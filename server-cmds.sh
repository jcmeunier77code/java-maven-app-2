#!/usr/bin/env bash

docker-compose -f docker-compose.yaml up --detach
echo "SUCCES"
export TEST=testvalue
