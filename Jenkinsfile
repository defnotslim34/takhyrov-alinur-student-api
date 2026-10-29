// ==============================================================================
// DevOps Midterm Project - Declarative Jenkins Pipeline
// Student: Alinur Takhyrov
// Student ID: 38110
// GitHub: defnotslim34
// Repository: takhyrov-alinur-student-api
// Job Name: Takhyrov_Alinur_Student_API
// ==============================================================================

pipeline {
    agent any

    environment {
        STUDENT_NAME    = 'Alinur Takhyrov'
        STUDENT_ID      = '38110'
        IMAGE_NAME      = 'takhyrov-alinur-student-api'
        IMAGE_TAG       = 'v1.0-takhyrov-alinur'
        DOCKER_REGISTRY = 'defnotslim34'
        FULL_IMAGE      = "${IMAGE_NAME}:${IMAGE_TAG}"
    }

    options {
        timeout(time: 20, unit: 'MINUTES')
        buildDiscarder(logRotator(numToKeepStr: '10'))
        timestamps()
    }

    stages {
        stage('Initialize & Banner') {
            steps {
                echo "=========================================================="
                echo " Starting CI/CD Pipeline for: ${env.STUDENT_NAME}"
                echo " Student ID                  : ${env.STUDENT_ID}"
                echo " Repository                  : ${env.IMAGE_NAME}"
                echo " Target Docker Image         : ${env.FULL_IMAGE}"
                echo " Timestamp                   : ${new Date().toString()}"
                echo "=========================================================="
            }
        }

        stage('Checkout') {
            steps {
                echo "[CHECKOUT] Retrieving source code from GitHub repository..."
                checkout scm
                echo "[CHECKOUT] Source code successfully checked out."
            }
        }

        stage('Build') {
            steps {
                echo "[BUILD] Compiling Spring Boot CRUD application using Gradle..."
                sh '''
                    echo "Compiler environment check for: ${STUDENT_NAME}"
                    chmod +x ./gradlew 2>/dev/null || true
                    if [ -f "./gradlew" ]; then
                        ./gradlew clean compileJava compileTestJava --no-daemon
                    else
                        gradle clean compileJava compileTestJava --no-daemon
                    fi
                '''
                echo "[BUILD] Compilation completed successfully."
            }
        }

        stage('Test') {
            steps {
                echo "[TEST] Running automated unit and integration tests..."
                sh '''
                    if [ -f "./gradlew" ]; then
                        ./gradlew test --no-daemon
                    else
                        gradle test --no-daemon
                    fi
                '''
                echo "[TEST] All tests passed for Alinur Takhyrov (ID: 38110)."
            }
            post {
                always {
                    junit allowEmptyResults: true, testResults: 'build/test-results/test/*.xml'
                }
                failure {
                    echo "[ALERT] Automated tests FAILED! Pipeline stopped for ${env.STUDENT_NAME}."
                }
            }
        }

        stage('Docker Build') {
            steps {
                echo "[DOCKER BUILD] Building personalized Docker image: ${env.FULL_IMAGE}..."
                sh '''
                    echo "Building Docker Image: ${FULL_IMAGE}"
                    docker build -t ${FULL_IMAGE} -t ${IMAGE_NAME}:latest .
                '''
                echo "[DOCKER BUILD] Docker image built successfully."
            }
            post {
                failure {
                    echo "[ALERT] Docker image build failed for ${env.FULL_IMAGE}!"
                }
            }
        }

        stage('Verify') {
            steps {
                echo "[VERIFY] Verifying Docker image existence and inspecting metadata..."
                sh '''
                    echo "Verifying image ${FULL_IMAGE} in local docker registry:"
                    docker images | grep "${IMAGE_NAME}" | grep "${IMAGE_TAG}" || docker images "${FULL_IMAGE}"
                    
                    echo "Image inspection details:"
                    docker inspect --format='ID: {{.Id}} | Size: {{.Size}} bytes | Created: {{.Created}}' "${FULL_IMAGE}"
                '''
                echo "=========================================================="
                echo " SUCCESS: CI/CD verification complete for ${env.STUDENT_NAME}"
                echo " Target Image: ${env.FULL_IMAGE} is ready for deployment."
                echo "=========================================================="
            }
        }
    }

    post {
        success {
            echo "Pipeline succeeded for Alinur Takhyrov (Student ID: 38110)!"
        }
        failure {
            echo "Pipeline failed for Alinur Takhyrov (Student ID: 38110). Please inspect logs above."
        }
        always {
            cleanWs deleteDirs: false, notFailBuild: true
        }
    }
}
