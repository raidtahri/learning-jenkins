<h1 align="center">12-hello-maven-ci-cd-full-pipeline</h1>

- This project represents a **complete CI/CD pipeline** for a Maven-based Java application, using **Jenkins, Docker, DockerHub, GitHub, and AWS EC2**.  
- It automates:
  - Semantic versioning with Maven
  - Building the app
  - Creating a Docker image
  - Pushing to Docker Hub
  - Deploying to a remote EC2 instance via SSH
  - Sending email notifications on pipeline failure
  - Triggering builds via GitHub Webhooks using the *Multibranch Scan Webhook Trigger Plugin*
- It's part of the [learning-jenkins](../) repository, which contains multiple Jenkins practice projects.

---

## Project structure

- `.dockerignore`: Excludes unnecessary files from Docker build context
- `.gitignore`: Defines files to ignore in Git version control
- `Dockerfile`:  Multi-stage Docker build for Java Maven app
- `Jenkinsfile`: Jenkins CI/CD pipeline definition
- `pom.xml`: Maven project descriptor
- `README.md`: You're reading it

---

## Prerequisites

To follow along with these projects and get strarted locally, you need:
- **Docker** installed locally (for testing builds)
- **Java 17** and **Maven 3.9+** installed locally (optional, for local build)
- A valid **Docker Hub account**
- **AWS EC2 instance** with:
  - Docker installed and configured
  - SSH access from Jenkins
  - Open port for SSH `22`
- **Jenkins server** with:
  - Jenkins **Multibranch Pipeline**
  - Maven tool named `maven3.9`
  - Docker installed
- Plugins installed properly configured (see below):
    - *SSH Agent*
    - *Multibranch Scan Webhook Trigger*
    - *Ignore Commit Strategy*
    - *Email Extension Plugin*
- Jenkins Credentials:
    - `dockerhub` (DockerHub username/password)
    - `github-user-pat` (GitHub Personal Access Token)
    - `ssh-ec2-eu-west-3-ec2-user` (SSH key for EC2)
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

### Configure Jenkins Multibranch Pipeline
1. In Jenkins, create a new Multibranch Pipeline job.
2. In the job configuration, point the pipeline to the repository and specify this project’s folder path:
12-hello-maven-ci-cd-full-pipeline/Jenkinsfile.
3. Ensure:
   - You have a Maven tool named maven3.9.
   - All credentials listed in the prerequisites are configured in Jenkins > Manage Credentials.

### Configure GitHub Webhook + Multibranch Scan Plugin
#### GitHub Webhook Setup:
1. Go to your GitHub repository → Settings → Webhooks
2. Click "Add webhook"
3. Set:
   - Payload URL: http://<your-jenkins-domain>/multibranch-webhook-trigger/invoke?job=<your-multibranch-job-name>
   - Content type: application/json
   - Disable SSL verification, if Jenkins is running on HTTP
   - Enable events: Just the push event (or more as needed)
   - Save webhook
4. Make sure Jenkins is publicly accessible
#### Configure Plugin in Jenkins:
1. Install Multibranch Scan Webhook Trigger Plugin.
2. In your multibranch job, go to Configure and check: ✅ “Scan by webhook”
### Avoid Infinite Trigger Loops:
1. Install Ignore Commit Strategy plugin
2. In job configuration > under Branch Sources
3. in Build strategies option click Add and select Ignore Committer Strategy
4. in List of author emails to ignore section you can List of author emails to ignore, in my case its `raid.tahri.contact@gmail.com`
### Configure Email Plugin (For Notifications)
1. Go to Manage Jenkins > Configure System
2. Locate Extended E-mail Notification or Email Notification
3. Configure:
  - SMTP Server (e.g., smtp.gmail.com)
  - SMTP Authentication (username & password or App Password)
  - Default user e-mail suffix
  - Test with the "Test Configuration by sending test e-mail" button
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
