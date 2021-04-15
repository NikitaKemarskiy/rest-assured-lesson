pipeline {
    agent any

    tools {
        maven "M3"
    }

    stages {
        stage('Testing') {
            steps {
                sh "mvn test"
            }

            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
    }
}
