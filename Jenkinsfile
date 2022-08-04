pipeline {

    agent any
    parameters {
        choice(name: 'VERSION', choice: ['1.1.0', '1.2.0', '1.3.0'], description: 'CACA')
        booleanParam(name: 'executeTests', defaultValue: true, description: 'PIPI')
    }

    stages {
        stage("build") {
            steps {
		        echo "building the application..."
            }
        }

        stage("test") {
            when {
                expression {
                    params.executeTests == true
                }
            }


            steps {
                 echo "testing the application..."
            }
        }
  
        stage("deploy") {
            steps {
                echo "deploying gros caca pipi"
                echo "deploying version ${params.VERSION}"

                }
            }
        }

    }
}
