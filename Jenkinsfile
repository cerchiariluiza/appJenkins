pipeline { 
    agent any 

    stages { 
        stage('STAGE 00'){ 
            steps{
                echo "Pipeline Usando Jenkinsfile"
            }
        }

        stage('STAGE 01'){ 
            steps{
                bat "mvn clean package -DskipTests=true"
            }
        }
        stage('unit test'){ 
            steps{
                echo "mvn test"
            }
        }
    } 
} 