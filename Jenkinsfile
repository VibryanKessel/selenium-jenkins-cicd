pipeline {
    triggers {
        upstream 'build-and-deploy-to-integration'
    }
    agent {
        docker {
            image 'maven:3.9.11-eclipse-temurin-24'
        }
    }
    stages {
        stage('Clean and Compile') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Run Login Tests') {
            steps {
                sh 'docker compose up -d \
                    batchs/run_login.sh'
            }
        }
        stage('Run Menu Tests') {
            steps {
                sh 'docker compose up -d \
                    batchs/run_menu.sh'
            }
        }
        stage('Run AddCandidate Tests') {
            steps {
                sh 'docker compose up -d \
                    batchs/run_add_candidate.sh'
            }
        }
        stage('Run Parcours TNR') {
            steps {
                sh 'docker compose up -d \
                    batchs/run_tnr.sh'
            }
        }
    }
    post {
        always {
            junit 'target/surefire-reports/**/*.xml'
        }
    }
}
