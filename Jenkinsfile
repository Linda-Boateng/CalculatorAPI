
pipeline {
	agent any

    environment {
		// Set Docker image name and tag
        DOCKER_IMAGE = "llindaboateng/calculator-app:latest"
        BRANCH = "master"
        SONAR_TOKEN = credentials('sonar-token')
    }

    stages {
		stage('Checkout') {
			steps {

				git branch: "${BRANCH}", url: 'https://github.com/Linda-Boateng/CalculatorAPI.git'
            }
        }

        stage('Build and Test') {
			steps {

				sh 'mvn clean install'
            }
        }

        stage('Build Docker Image') {
			steps {

				sh 'docker build -t ${DOCKER_IMAGE} .'
                sh 'docker run -d -p 3004:6000 ${DOCKER_IMAGE}'
            }
        }

         stage('Code Coverage Analysis') {
			steps {
				sh 'mvn jacoco:report'
            }
        }

         stage('Code Quality Analysis with SonarQube') {
			steps {
				withSonarQubeEnv('SonarQube Server') {
					sh "mvn sonar:sonar -Dsonar.projectKey=DevOpsLab3 -Dsonar.projectName='DevOpsLab3'"
					//-Dsonar.login=${SONAR_TOKEN}
}
            }
        }

 //stage('SonarQube Analysis') {
 //   withSonarQubeEnv() {
	//			sh "mvn sonar:sonar -Dsonar.projectKey=DevOpsLab3 -Dsonar.projectName='DevOpsLab3'"
 //   }
 // }

        stage('Push Docker Image') {
			steps {

				withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
					sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                }

                sh 'docker push ${DOCKER_IMAGE}'
            }
        }
    }

    post {
		success {
			echo 'Pipeline completed successfully!'
        }
        failure {
			echo 'Pipeline failed!'
        }
    }
}
