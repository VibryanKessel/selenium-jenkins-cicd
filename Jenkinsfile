pipeline {
    triggers {
        upstream 'build-and-deploy-to-integration'
    }
    agent {
        dockerCompose {
            yamlFile 'docker-compose.selenium-grid.yml'
            service 'tests'
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
