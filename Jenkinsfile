pipeline {

    agent none


    stages {


        stage("test") {

                            steps {
                		        script {
                                    echo "building the application"
                                    echo "executing the pipeline for branch $BRANCH_NAME"
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
                        echo "building the application"
                    }
                }

        }


        stage("deploy") {

                    when {
                        expression {
                            BRANCH_NAME == 'master'
                        }
                    }

                    steps {
        		        script {
        		            echo "building the application"


        		        }
        		        }
        		    }

        }
    }


