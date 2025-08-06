<h1 align="center">07-hello-maven-shared-library-with-scr-pipeline</h1>

- This project demonstrates advanced Jenkins pipeline modularization using a Shared Library with Groovy classes under the `src/` directory.
- It's part of the [learning-jenkins](../) repository, which contains multiple Jenkins practice projects.

---
## Project structure

### 07-hello-maven-shared-library-with-scr-pipeline

- `.dockerignore`: Excludes unnecessary files from Docker build context
- `.gitignore`: Defines files to ignore in Git version control
- `Dockerfile`:  Multi-stage Docker build for Java Maven app
- `Jenkinsfile`: Defines the Jenkins pipeline stages
- `pipeline.groovy`: Shared pipeline logic (functions)
- `pom.xml`: Maven project descriptor
- `README.md`: Documentation for this project

### [learning-jenkins-shared-library-with-src](https://github.com/raidtahri/learning-jenkins-shared-library-with-src.git)
- `src/com/example`
  - `DockerHelper.groovy`: Class to encapsulate Docker operations
- `vars/`
  - `buildApp.groovy`:  Defines reusable build logic
  - `buildDockerImage.groovy`: Defines Docker image build logic
  - `pushToDockerHub.groovy `: Pushes image to Docker Hub
- `.gitignore`: Defines files to ignore in Git version control
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
- Shared Library with `src/` and `vars/` configured in Jenkins (see below)
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
07-hello-maven-shared-library-with-scr-pipeline/Jenkinsfile.
3. Ensure:
   - You have a Maven tool named maven3.9.
   - You’ve added Docker Hub credentials with the ID: dockerhub.
4. Configure Jenkins for Shared Library
 - Go to Jenkins > Manage Jenkins > Configure System.
 - Scroll down to Global Pipeline Libraries.
 - Add a new library:
   - Name: jenkins-shared-library-with-src
   - Default version: main
   - Retrieval method: Modern SCM
   - Source Code Management: Git
     - Project Repository: [https://github.com/raidtahri/learning-jenkins-shared-library-with-src.git
](https://github.com/raidtahri/learning-jenkins-shared-library-with-src.git)
---

## Author

Made with ❤️ by [Raid Tahri](https://github.com/raidtahri).
See the root [README](../README.md#author) for more details.
