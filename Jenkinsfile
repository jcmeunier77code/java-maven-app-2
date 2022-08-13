pipeline {

    agent any
    tools {
        maven 'maven-3.8.6'
    }

    stages {

        stage("build jar") {

                    steps {
        		        script {
        		        echo "building the application"
        		        sh 'mvn package'
        		        }
                    }
                }

        stage("build image") {

                    steps {
        		        script {
        		        echo "building the application..."
        		        }
        		        }
                    }
                }


        stage("deploy") {
                    steps {
                        script {
        		        echo "deploying the application..."
                        }
                    }
                }
        }



