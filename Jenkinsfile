pipeline {
    agent any

    environment {
        IMAGE_NAME = "mahendra3/calculator"
    }

    stages{

        stage('stage 1: Git clone repo') {
            steps {
                git branch: 'main' ,
                url: ' https://github.com/Mahendra-Nath/calculator.git '
            }
        }

        stage(' 2: Maven Build ') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage(" 3: Build Docker Image ") {
            steps {
                script{
                    docker_image = docker.build "$IMAGE_NAME:latest"
                }

            }
        }

        stage(" 4 : Push Docker image to HUB") {

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

        stage('Stage 5: clean Docker Images') {
            steps {
                script {
                    sh 'docker container prune -f'
                    sh 'docker image prune -f'
                }
            }
        }

        stage('Stage 6: Ansible Deployment') {
            steps {

                sh 'ansible-playbook Deployment/deploy.yml -i Deployment/inventory.ini '

            }
        }

    }

    post {
        always {
            mail(
                to: 'mahendranath281201@gmail.com,Mahendranath.Gulla@iiitb.ac.in',
                subject: "Build ${currentBuild.currentResult}",
                body: "Build URL: ${env.BUILD_URL}"
            )
        }
    }

}