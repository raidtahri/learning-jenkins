<h1 align="center">☕ Hello Maven Pipeline</h1>

This is a minimal **Java Maven** project built to demonstrate a **Jenkins pipeline** with CI/CD stages and Docker integration.

It's part of the [learning-jenkins](../) repository, which contains multiple Jenkins practice projects.

---

## Project Overview

This app is a simple "Hello World" Java program built with **Maven**, packaged into a **Docker image**, and automated using a **Jenkins declarative pipeline**.

It follows DevOps best practices such as:
- ✅ CI/CD with Jenkinsfile
- ✅ Docker-based builds (multi-stage)
- ✅ Java 17 compliance
- ✅ Clean Git structure

---

## Technologies Used

| Tool         | Version       | Purpose                        |
|--------------|---------------|--------------------------------|
| Java         | 17            | Language & runtime             |
| Maven        | 3.8.6         | Build & dependency management  |
| Jenkins      | Any (pipeline) | CI/CD automation              |
| Docker       | Latest        | Containerization               |

---

## How to Run Locally (Java & Maven)

1. Make sure you have Java 17 and Maven installed:

```bash
java -version
mvn -version
```
2. Build the app:
```bash
mvn clean package
```
3. Run it:
```bash
java -cp target/hello-maven-app-1.0-SNAPSHOT.jar com.example.Main
```

You should see:
Hello from Maven + Jenkins!

---

## How to Build & Run with Docker

Requires Docker installed
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

---

## Learning Objectives

  - Understand Java + Maven CI flow

  - Write and test Jenkins pipelines

  - Containerize apps using multi-stage Docker builds

  - Prepare for real-world DevOps tasks

---

## Author

Made with ❤️ by [Raid Tahri] as part of a DevOps learning journey.
