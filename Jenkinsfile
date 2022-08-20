#!/usr/bin/env groovy

def gv

pipeline {

    agent any
    tools {
        maven 'maven-3.8.6'
    }
    environment {
        IMAGE_NAME = 'jcmeunier77/bootcamp-java-maven-app:jma-4.0'
    }

    stages {

        stage("init") {
                steps {
                    script {
                        gv = load "script.groovy"
                    }
                }

        }


        stage("build jar") {

                    steps {
        		        script {
                            gv.buildJar(env.IMAGE_NAME)
        		        }
                    }
                }

        stage("build image") {

                    steps {
        		        script {
        		            gv.buildImage()


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


