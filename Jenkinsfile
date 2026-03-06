pipeline {
    agent any

    environment {
        IMAGE_NAME = "mahendra3/calculator"
    }

    stages{

        stage(' 1: cloning repository from GitHub') {
            steps {
                git branch: 'main' ,
                url: ' https://github.com/Mahendra-Nath/calculator.git '
            }
        }

        stage(' 2: Maven Build ') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage(' 3: Unit Testing ') {
                    steps {
                        sh 'mvn test'
                    }
                }

        stage(" 4: Building Docker Image ") {
            steps {
                script{
                    docker_image = docker.build "$IMAGE_NAME:latest"
                }

            }
        }

        stage(" 5: Pushing Docker image to DockerHub") {

            steps {
                withCredentials([usernamePassword(credentialsId: 'DockerPwd',
                                  usernameVariable: 'USER',
                                  passwordVariable: 'PASS')]) {
                    sh '''
                        echo $PASS | docker login -u $USER --password-stdin
                        docker push $IMAGE_NAME
                    '''
                }
            }
        }

        stage(' 6: clean Docker Images') {
            steps {
                script {
                    sh 'docker container prune -f'
                    sh 'docker image prune -f'
                }
            }
        }

        stage(' 7: Ansible Deployment') {
            steps {

                sh 'ansible-playbook Deployment/deploy.yml -i Deployment/inventory.ini '

            }
        }

    }

    post {
        always {
            mail(
                to: 'mahendranath281201@gmail.com',
                subject: "Build ${currentBuild.currentResult}",
                body: "Build URL: ${env.BUILD_URL}"
            )
        }
    }

}