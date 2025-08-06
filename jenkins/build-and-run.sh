#!/bin/bash
set -e
DOCKER_GID=$(getent group docker | cut -d: -f3)
export DOCKER_GID
echo "Building with Docker GID: $DOCKER_GID"
docker compose up -d --build

