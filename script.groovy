def buildJar() {
    echo "building the application"
    sh 'mvn package'
}

def buildImage() {
    echo "building the docker image"
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t jcmeunier77/bootcamp-java-maven-app:jma-4.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker push jcmeunier77/bootcamp-java-maven-app:jma-4.0"
    }
}

def deployApp() {
    echo "deploying the application..."
    echo "c'est la fête du slip"
}

return this