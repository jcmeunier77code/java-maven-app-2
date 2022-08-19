pipeline {

    agent none


    stages {

        stage("build") {
                steps {
                    script {
                        echo "building the application"
                    }
                }

        }


        stage("test") {

                    steps {
        		        script {
                            echo "building the application"
        		        }
                    }
                }

        stage("deploy") {

                    steps {
        		        script {
//         		            echo "building the application"
                            def dockerCmd = 'docker run -p 3080:3080 -d jcmeunier77/bootcamp-java-maven-app:jma-4.0'
                            sshagent(['ec2-server-key']) {
                            sh "ssh -o StrictHostKeyChecking=no ec2-user@54.194.84.33 ${dockerCmd}"
                            // some block
                            }

        		        }
        		        }
        		    }

        }
    }


