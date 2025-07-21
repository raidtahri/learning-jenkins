def buildApp(goal) {
    dir('hello-maven-scripted-pipeline') {
        echo "Building the app with Maven goal: ${goal}"
        sh "mvn ${goal}"
    }
}

def buildDockerImage(imageName, imageTag) {
    dir('hello-maven-scripted-pipeline') {
        withCredentials([usernamePassword(
            credentialsId: 'dockerhub',
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )]) {
            echo "Building Docker image with tag: ${imageTag}"
            sh "docker build -t ${DOCKER_USER}/${imageName}:${imageTag} ."
        }
    }
}

def confirmPushToDockerHub() {
    return input(
        message: 'Do you want to push the image to Docker Hub?',
        ok: 'Proceed',
        parameters: [
            booleanParam(name: 'CONFIRM_PUSH', defaultValue: true, description: 'Confirm push to Docker Hub')
        ]
    )
}

def pushToDockerHub(imageName, imageTag) {
    withCredentials([usernamePassword(
        credentialsId: 'dockerhub',
        usernameVariable: 'DOCKER_USER',
        passwordVariable: 'DOCKER_PASS'
    )]) {
        echo "Pushing image ${DOCKER_USER}/${imageName}:${imageTag} to Docker Hub"
        sh """
            echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
            docker push ${DOCKER_USER}/${imageName}:${imageTag}
            docker logout
        """
    }
}

return this
