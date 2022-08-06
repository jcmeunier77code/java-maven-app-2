def buildJar() {
    echo "building the application..."
    sh "mvn package"
}

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh 'docker build -t jcmeunier77/bootcamp-java-maven-app:jma-2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push jcmeunier77/bootcamp-java-maven-app:jma-2.0'
    }

def deployApp() {
    echo "Deploying the application...YES!!!"
}

return this