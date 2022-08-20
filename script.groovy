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
    def shellCmd = "bash ./server-cmds.sh"
    sshagent(['ec2-server-key']) {
        sh "scp server-cmds.sh ec2-user@54.194.84.33:/home/ec2-user"
        sh "scp docker-compose.yaml ec2-user@54.194.84.33:/home/ec2-user"
        sh "ssh -o StrictHostKeyChecking=no ec2-user@54.194.84.33 ${shellCmd}"
        echo "C'est la fête du slip, yeeeaaaahhhh !!!"
    }
}

return this
