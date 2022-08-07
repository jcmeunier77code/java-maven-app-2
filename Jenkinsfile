pipeline {

    agent any
    tools {
        maven 'maven-3.8.6'
    }

    stages {

        stage("test") {
                    steps {
        		        script {
        		        echo "testing the application..."
        		        echo "Executing pipeline for $BRANCH_NAME"
        		        }
                    }
                }

        stage("build") {
                    when {
                        expression {
                            BRANCH_NAME == 'master'
                        }
                    }
                    steps {
        		        script {
        		        echo "building the application..."
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
    }


