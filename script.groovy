def buildJar() {
    echo "building the application"
    sh 'mvn package'
}

def buildImage(String imageName) {
    echo "building the docker image"
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
//        sh 'docker build -t jcmeunier77/bootcamp-java-maven-app:jma-4.0 .'
        sh "docker build -t $imageName ."
        sh "echo $PASS | docker login -u $USER --password-stdin"
//        sh "docker push jcmeunier77/bootcamp-java-maven-app:jma-4.0"
        sh "docker push $imageName"
    }
}

def deployApp() {
    echo "deploying the application..."
    def shellCmd = "bash ./server-cmds.sh ${IMAGE_NAME}"
    def ec2Instance = "ec2-user@54.194.84.33"
    sshagent(['ec2-server-key']) {
        sh "scp server-cmds.sh $ec2Instance:/home/ec2-user"
        sh "scp docker-compose.yaml $ec2Instance:/home/ec2-user"
        sh "ssh -o StrictHostKeyChecking=no $ec2Instance ${shellCmd}"
        echo "C'est la fête du slip, yeeeaaaahhhh !!!"
    }
}

return this
