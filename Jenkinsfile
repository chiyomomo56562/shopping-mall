// 에이전트 지정
pipeline {
    agent any

    environment{
        IMAGE_NAME = 'chiyomomo/shopping-mall'
        IMAGE_TAG = 'latest'
    }

// 파이프라인 단계
    stages {
        // stage('Install DockerCLI'){
        //     steps {
        //         sh 'sudo apt-get update'
        //         sh 'sudo apt-get install -y docker.io'
        //     }
        // }

        stage('Build'){
            steps {
                echo "Building Docker image ${IMAGE_NAME}:${IMAGE_TAG}..."
                // 'docker build' 명령어가 Dockerfile에 정의된
                // 'builder' 스테이지를 자동으로 실행하게 됩니다.
                sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ../../backend/demo"
            }
        }

        stage('Push'){
            steps {
                echo "Pushing Docker image ${IMAGE_NAME}:${IMAGE_TAG}..."
                sh "docker push ${IMAGE_NAME}:${IMAGE_TAG}"
            }
        }

        stage('Deploy'){
            steps {
                echo "Deploying Docker image ${IMAGE_NAME}:${IMAGE_TAG}..."
                sh "kubectl set image deployment/backend-app backend-container=${IMAGE_NAME}:${IMAGE_TAG}"
            }
        }

    }
}