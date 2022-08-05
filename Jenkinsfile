def gv

pipeline {

    agent any
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: 'CACA')
        booleanParam(name: 'executeTests', defaultValue: true, description: 'PIPI')
    }

    stages {

        stage("init") {
                    steps {
        		        script {
        		        gv = load "script.groovy"
        		        }
                    }
                }

        stage("build") {
            steps {
		        script {
		        gv.buildApp()
		        }
            }
        }

        stage("test") {
            when {
                expression {
                    params.executeTests == true
                }
            }


            steps {
                 script {
                 gv.testApp()
                 }
            }
        }
  
        stage("deploy") {
            steps {
                 script {
                 gv.deployApp()
                  }
                }
            }
        }

    }
