<h1 align="center">01-hello-maven-basic-pipeline</h1>

- This project demonstrates a **basic Jenkins pipeline** setup for a simple Java Maven application. It's the foundational project in a series designed to explore CI/CD concepts using Jenkins.
- It's part of the [learning-jenkins](../) repository, which contains multiple Jenkins practice projects.

---

## Project structure

This project contains:

- `.gitignore`: defines files to ignore in Git version control
- `Jenkinsfile`: defines the Jenkins pipeline stages
- `README.md`: documentation for this project


---

## Prerequisites
To follow along with these projects and get strarted locally, you need:
- Jenkins installed and configured
- Basic understanding of Jenkins Pipelines
- Java and Maven

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

## How to configure Jenkins
- In Jenkins, create a new Pipeline project.
- Point it to this repository.
- Run the pipeline to observe the three basic stages.

---

## Author

Made with ❤️ by [Raid Tahri](https://github.com/raidtahri).  
See the root [README](../README.md#author) for more details.
