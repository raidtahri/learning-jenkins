# hello-maven-parameterized-pipeline

This project demonstrates how to use **manual input parameters** and interactive `input` steps within a Jenkins declarative pipeline. It builds a simple Maven application, builds a Docker image, and then **waits for manual approval** before pushing to Docker Hub.
The project is part of the **Learning Jenkins** repository and builds upon the basic `hello-maven` application.

## Features
- Maven build with user-defined goals
- Docker image creation with dynamic tags
- Secure credential injection for Docker Hub
- Manual input before pushing image

## Files Included
- `Jenkinsfile`: Declarative pipeline with parameters
- `Dockerfile`: Builds the app image
- `.gitignore`: Ignores unnecessary files in Git
- `.dockerignore`: Ignores unnecessary files in Docker build context
- `pom.xml`: Maven project descriptor
- `README.md`: Project description and usage
