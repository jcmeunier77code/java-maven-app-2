pipeline {

    agent any
    stages {

        stage("build jar") {
                    steps {
        		        script {
        		            echo "building the application..."
        		            sh "mvn package"
        		        }
                    }
                }

        stage("build image") {
            steps {
		        script {
		            echo "building the docker image..."
		            withCredentials([usernamePassword(CredentialsId: 'docker-hub-repo', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
		            sh 'docker build -t jcmeunier77/bootcamp-java-maven-app:jma-2.0'
		            sh "echo $PASS | docker login -u $USER --password-stdin"
		            sh 'docker push jcmeunier77/bootcamp-java-maven-app:jma-2.0'
                }
		        }
            }
        }

        stage("deploy") {
            steps {
                 script {
                 echo "Deploying to ${ENV}"
                  }
                }
            }
        }

    }
