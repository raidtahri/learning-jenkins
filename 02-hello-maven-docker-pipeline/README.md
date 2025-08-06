<h1 align="center">02-hello-maven-docker-pipeline</h1>

- This project demonstrates how to build a **Java Maven application**, **package it into a Docker image**, and **push it to Docker Hub** using a Jenkins pipeline. It builds on the previous basic pipeline by introducing real Maven and Docker integration.
- It's part of the [learning-jenkins](../) repository, which contains multiple Jenkins practice projects.

---
## Project structure

This project contains:

- `.dockerignore`: Excludes unnecessary files from Docker build context
- `.gitignore`: Defines files to ignore in Git version control
- `Dockerfile`:  Multi-stage Docker build for Java Maven app
- `Jenkinsfile`: Defines the Jenkins pipeline stages
- `README.md`: Documentation for this project

---

## Prerequisites

To follow along with these projects and get strarted locally, you need:
- **Docker** installed locally (for testing builds)
- **Java 17** and **Maven 3.9+** installed locally (optional, for local build)
- A valid **Docker Hub account**
- Jenkins configured with:
  - A **Maven tool** named `maven3.9`
  - A **credential** in Jenkins with ID `dockerhub` containing your Docker Hub username/password

---

## How to Use This Project
### How to Run Locally (Java & Maven)
1. Open a terminal inside this project directory:
   ```bash
   mvn clean package
   java -jar target/hello-maven-app-1.0-SNAPSHOT.jar
   ```
2. Output:
Hello from Jenkins + Maven!

### How to Build & Run with Docker
1. Build the image:
```bash
docker build -t hello-maven-app .
```
2. Run the container:
```bash
docker run --rm hello-maven-app
```

Expected output:
Hello from Maven + Jenkins!

### How to Configure Jenkins Pipeline
1. Create a Pipeline job in Jenkins.
2. In the job configuration, point the pipeline to the repository and select this project directory.
3. Ensure:
   - You have a Maven tool named maven3.9.
   - You’ve added Docker Hub credentials with the ID: dockerhub.

---

## Author

Made with ❤️ by [Raid Tahri](https://github.com/raidtahri).
See the root [README](../README.md#author) for more details.
