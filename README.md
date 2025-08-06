<h1 align="center">learning-jenkins</h1>

- This repository is a **hands-on lab** designed to help you learn Jenkins CI/CD through **practical mini-projects** based on a real Java Maven application. Each project focuses on a specific Jenkins Pipeline concept, from basic pipelines to advanced features like shared libraries and remote deployments via SSH.
- All projects build and deploy the same base **Hello Maven App**, allowing you to focus entirely on learning **Pipeline as Code**, **automation**, and **CI/CD workflows** with Jenkins.

---

## Projects List

| Project                  | Topic                                           |
|-------------------------|-------------------------------------------------------|
| *01*| [01-hello-maven-basic-pipeline](./01-hello-maven-basic-pipeline/) |
| *02* | [02-hello-maven-docker-pipeline](./02-hello-maven-docker-pipeline/)|
| *03* |[03-hello-maven-parameterized-pipeline](./03-hello-maven-parameterized-pipeline/)           |
| *04* |[04-hello-maven-input-parameters-pipeline](./04-hello-maven-input-parameters-pipeline/)|
| *05* |[05-hello-maven-scripted-pipeline](./05-hello-maven-scripted-pipeline/)              |
| *06* | [06-hello-maven-shared-library-pipeline](./06-hello-maven-shared-library-pipeline/) |
| *07* | [07-hello-maven-shared-library-with-scr-pipeline](./07-hello-maven-shared-library-with-scr-pipeline/) |
| *08* | [08-hello-maven-local-shared-library-pipeline](./08-hello-maven-local-shared-library-pipeline/) |
| *09* | [09-hello-maven-versioning-pipeline](./09-hello-maven-versioning-pipeline/) |
| *10* | [10-hello-maven-ec2-docker-ssh-deploy-pipeline](./10-hello-maven-ec2-docker-ssh-deploy-pipeline/) |
| *11* | [11-hello-maven-ec2-docker-ssh-scriptedDeploy-pipeline](./11-hello-maven-ec2-docker-ssh-scriptedDeploy-pipeline/) |
| *12* | [12-hello-maven-ci-cd-full-pipeline](./12-hello-maven-ci-cd-full-pipeline12-hello-maven-ci-cd-full-pipeline/) |

---

## Tech Stack Used

- **Languages**: Java.
- **Build Tools**: Maven.
- **DevOps Tools**: Jenkins, Docker & Docker Compose, Jenkins Shared Library (Local ˇRemote), DockerHub.
- **Cloud & Deployment**: AWS EC2.
- **VCS & Hosting**: GitHub  

---

## Prerequisites

To follow along with these projects and get strarted locally, you need:

- ✅ Basic knowledge of Git and Docker
- ✅ Jenkins installed locally, or running in a Docker container  
- ✅ Docker and Docker Compose installed and running on your machine
- ✅ Docker Hub account (for pushing/pulling container images)
- ✅ Java 17+ and Maven (for manual app builds, optional)
- ✅ AWS EC2 Instance (for SSH deployment pipelines)
- ✅ Python, for scripting and packaging projects

---

## How to Use This Repo

### 1. Clone the Repository
```bash
git clone https://github.com/YOUR_USERNAME/Learning-Jenkins.git
cd Learning-Jenkins/jenkins
```
### 2. Build and start Jenkins container
```bash
chmod +x build-and-run.sh
./build-and-run.sh  
```
### 3.Access Jenkins
- Open: http://localhost:8080
- Unlock using the password from:
```bash
docker exec -it jenkins cat /var/jenkins_home/secrets/initialAdminPassword
```
### 4.Start experimenting!
- Each project contains a Jenkinsfile.
- Create pipeline jobs in Jenkins for each folder and point to the Git repo path.

---

## Author

Raid Tahri
> Aspiring DevOps & AWS Cloud Engineer

GitHub: [github.com/raidtahri](https://github.com/raidtahri)  
LinkedIn: [linkedin.com/in/raidtahri](https://linkedin.com/in/raidtahri)  
Email: raid.tahri.contact@gmail.com

## License

This project is licensed under the [MIT License](LICENSE). 

Feel free to use, copy, or improve for your own learning or projects.

