#!/usr/bin/env bash

set -e

DOCKER_PASS="$1"
DOCKER_USER="$2"
IMAGE_NAME="$3"
IMAGE_TAG="$4"

echo "${DOCKER_PASS}" | docker login -u "${DOCKER_USER}" --password-stdin
docker rm -f "${IMAGE_NAME}" || true
docker pull "${DOCKER_USER}/${IMAGE_NAME}:${IMAGE_TAG}"
docker run -d --name "${IMAGE_NAME}" "${DOCKER_USER}/${IMAGE_NAME}:${IMAGE_TAG}"
docker logout

