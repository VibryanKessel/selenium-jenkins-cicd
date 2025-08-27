pipeline {
    triggers {
        upstream 'build-and-deploy-to-integration'
    }
    agent {
        docker {
            image 'selenium/standalone-chrome:124.0'
            args 'entrypoint='
        }
    }
    stages {
        stage('Clean and Compile') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Run AddCandidate Tests') {
            steps {
                sh 'batchs/run_add_candidate.sh'
            }
        }
        stage('Run Menu Tests') {
            steps {
                sh 'batchs/run_menu.sh'
            }
        }
        stage('Run Parcours TNR') {
            steps {
                sh 'batchs/run_tnr.sh'
            }
        }
    }
    post {
        always {
            junit 'target/surefire-reports/**/*.xml'
        }
    }
}
