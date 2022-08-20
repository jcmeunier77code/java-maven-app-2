#!/usr/bin/env groovy

def gv

pipeline {

    agent any
    tools {
        maven 'maven-3.8.6'
    }
//     environment {
//         IMAGE_NAME = 'jcmeunier77/bootcamp-java-maven-app:jma-4.0'
//     }

    stages {

        stage("init") {
                steps {
                    script {
                        gv = load "script.groovy"
                    }
                }

        }

        stage("increment version") {
            steps {
                echo 'increment app version...'
                sh 'mvn build-helper:parse-version versions:set \
                    -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
                    versions:commit'
                def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
                def version = matcher[0][1]
                env.IMAGE_NAME = "$version-$BUILD_NUMBER"
            }
        }

        stage("build jar") {

                    steps {
        		        script {
                            gv.buildJar()
        		        }
                    }
                }

        stage("build image") {

                    steps {
        		        script {
        		            gv.buildImage(env.IMAGE_NAME)


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

        stage("commit version update") {
                    steps {
                        script {
                            withCredentials([sshUserPrivateKey(credentialsId: "da38a375-03b3-4b5f-91af-f50d2a0665b9", keyFileVariable: 'keyfile')]) {
//                             sshagent(['jenkins']) {
                                sh 'git config user.email "jenkins@example.com"'
                                sh 'git config user.name "jenkins"'
                                sh "cat $keyfile"
                                sh 'git status'
                                sh 'git branch'
                                sh 'git config --list'

                                sh 'git remote set-url origin git@github.com:jcmeunier77code/java-maven-app-2.git'
                                sh 'git add .'
                                sh 'git commit -m "ci: version bump"'
        //                         sh 'git push origin HEAD:3-jenkins-jobs-ec2'
                }
            }
        }
    }
}

