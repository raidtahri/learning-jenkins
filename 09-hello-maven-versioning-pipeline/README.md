<h1 align="center">09-hello-maven-versioning-pipeline</h1>

- This project demonstrates how to automate **semantic versioning** using Maven and Jenkins. Each time the pipeline runs, it automatically increments the patch version, builds the app and Docker image, and pushes both the image and updated version to Docker Hub and GitHub.
- It's part of the [learning-jenkins](../) repository, which contains multiple Jenkins practice projects.

---
## Project structure

- `.dockerignore`: Excludes unnecessary files from Docker build context
- `.gitignore`: Defines files to ignore in Git version control
- `Dockerfile`:  Multi-stage Docker build for Java Maven app
- `Jenkinsfile`: Pipeline that handles version bumping
- `pom.xml`: Maven project descriptor
- `README.md`: Documentation for this project

---

## Prerequisites

To follow along with these projects and get strarted locally, you need:
- **Docker** installed locally (for testing builds)
- **Java 17** and **Maven 3.9+** installed locally (optional, for local build)
- A valid **Docker Hub account**
- Credentials:
  - `dockerhub`: DockerHub username and password
  - `github-user-pat`: GitHub Personal Access Token (PAT) for pushing changes
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
2. In the job configuration, point the pipeline to the repository and specify this project’s folder path:
09-hello-maven-versioning-pipeline/Jenkinsfile.
3. Ensure:
   - You have a Maven tool named maven3.9.
   - You’ve added Docker Hub credentials with the ID: dockerhub.
4. This pipeline introduces a semantic versioning bump strategy using Maven plugins and shell scripting.
5. The maven command
```bash
mvn build-helper:parse-version versions:set \
  -DnewVersion=${parsedVersion.majorVersion}.${parsedVersion.minorVersion}.${parsedVersion.nextIncrementalVersion} \
  versions:commit
```
increments only the patch version (x.y.Z → x.y.Z+1), leaving major/minor.
   
---

## Author

Made with ❤️ by [Raid Tahri](https://github.com/raidtahri).
See the root [README](../README.md#author) for more details.

