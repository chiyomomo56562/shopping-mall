// 에이전트 지정
pipeline {
    agent {
        // 스프링 애플리케이션 빌드를 위해 JDK 21과 Maven이 포함된 이미지를 사용
        docker {
            image 'maven:3.9.6-openjdk-21-slim'
            // 빌드 에이전트에서 Docker를 사용하기 위해 호스트의 Docker 소켓을 마운트
            args '-v /var/run/docker.sock:/var/run/docker.sock'
        }
    }

    environment{
        IMAGE_NAME = 'chiyomomo/shopping-mall'
        IMAGE_TAG = 'latest'
    }

// 파이프라인 단계
    stages {
        stage('Install Tools') {
            steps {
                echo "Installing Docker CLI and kubectl..."
                // 에이전트 이미지(Debian 기반)에 Docker CLI와 kubectl을 설치합니다.
                // docker agent는 기본적으로 root 권한으로 실행되므로 sudo가 필요 없습니다.
                sh '''
                    apt-get update
                    apt-get install -y docker.io curl
                    curl -LO https://storage.googleapis.com/kubernetes-release/release/$(curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt)/bin/linux/amd64/kubectl
                    chmod +x ./kubectl
                    mv ./kubectl /usr/local/bin/kubectl
                '''
            }
        }

        stage('Install DockerCLI'){
            steps {
                sh 'sudo apt-get update'
                sh 'sudo apt-get install -y docker.io'
            }
        }

        stage('Build'){
            steps {
                echo "Building Docker image ${IMAGE_NAME}:${IMAGE_TAG}..."
                // 'docker build' 명령어가 Dockerfile에 정의된
                // 'builder' 스테이지를 자동으로 실행하게 됩니다.
                sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
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