# hello-maven-parameterized-pipeline

This project demonstrates how to use Jenkins pipeline parameters with a Maven-based Java application.  
It allows users to control build behavior dynamically, including Maven goals, Docker image tags, environment selection (dev/staging/prod), and whether to push the Docker image to Docker Hub.

The project is part of the **Learning Jenkins** repository and builds upon the basic `hello-maven` application.

## Features
- Maven build with user-defined goals
- Docker image creation with dynamic tags
- Environment selection using pipeline parameters
- Conditional Docker Hub push

## Files Included
- `Jenkinsfile`: Declarative pipeline with parameters
- `Dockerfile`: Builds the app image
- `.gitignore`: Ignores unnecessary files in Git
- `.dockerignore`: Ignores unnecessary files in Docker build context
- `pom.xml`: Maven project descriptor
- `README.md`: Project description and usage
