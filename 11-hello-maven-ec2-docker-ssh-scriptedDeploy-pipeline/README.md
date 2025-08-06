<h1 align="center">11-hello-maven-ec2-docker-ssh-scriptedDeploy-pipeline</h1>

- This project showcases a full CI/CD pipeline using **Maven**, **Docker**, and **Jenkins**, with a custom **Bash script** (`deploy-to-ec2.sh`) to deploy the Docker container on a **remote AWS EC2 instance** via SSH. The pipeline builds the app, packages it in Docker, pushes it to Docker Hub, and deploys it on EC2 using a secure scripted method.
- It's part of the [learning-jenkins](../) repository, which contains multiple Jenkins practice projects.

---

## Project structure

- `.dockerignore`: Excludes unnecessary files from Docker build context
- `.gitignore`: Defines files to ignore in Git version control
- `Dockerfile`:  Multi-stage Docker build for Java Maven app
- `Jenkinsfile`: Jenkins CI/CD pipeline definition
- `deploy-to-ec2.sh `: Bash script to deploy container to EC2
- `pom.xml`: Maven project descriptor
- `README.md`: You're reading it

---

## Prerequisites

To follow along with these projects and get strarted locally, you need:
- **Docker** installed locally (for testing builds)
- **Java 17** and **Maven 3.9+** installed locally (optional, for local build)
- A valid **Docker Hub account**
- AWS EC2 instance with:
  - Docker installed and configured
  - SSH access from Jenkins
  - Open port for SSH `22`
- Jenkins server with:
  - Maven tool named `maven3.9`
  - SSH Agent plugin
  - Docker installed
  - DockerHub credentials (`dockerhub`)
  - EC2 SSH credentials (`ssh-ec2-eu-west-3-ec2-user`)

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
11-hello-maven-ec2-docker-ssh-scriptedDeploy-pipeline/Jenkinsfile.
3. Ensure:
   - You have a Maven tool named maven3.9.
   - You’ve added Docker Hub credentials with the ID: dockerhub.
   - You've added SSH access to EC2 instance with the ID: ssh-ec2-eu-west-3-ec2-user.
4. This Jenkins pipeline automates the full lifecycle of the application.

### How to Deploy to EC2
Make sure:
 - Your EC2 security group allows inbound traffic on port 22 (SSH)
 - The instance has Docker installed
 - The Jenkinsfile references your EC2 instance using the correct public IP address
 - Replace the IP address below with your own EC2 Public IP:
```bash
ssh ec2-user@<YOUR_EC2_PUBLIC_IP>
```
 - In this example, it’s set as:
```bash
ssh ec2-user@52.47.140.248
```

---

## Author

Made with ❤️ by [Raid Tahri](https://github.com/raidtahri).
See the root [README](../README.md#author) for more details.
