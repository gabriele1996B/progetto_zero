pipeline {
    agent { label 'docker' } // Sostituisci 'Docker' con il nome corretto del nodo, se necessario
    environment {
        REPO_URL = 'https://github.com/gabriele1996B/progetto_zero.git' // URL del repository GitHub
        BRANCH = 'main' // Branch da cui clonare
    }
    stages {
        stage('Clone Repository') {
            steps {
                // Clonare il repository GitHub
                git branch: "${BRANCH}", url: "${REPO_URL}"
            }
        }
        
        stage('Build Docker Image') {
            steps {
                // Costruire l'immagine Docker
                sh 'docker build -t image_todolist .'
            }
        }
         stage('Deployer Docker Container') {
            steps {
                //rilascio immagine Docker
                sh 'docker run -dt image_todolist'
            }
        }
    }
    
    post {
        success {
            echo 'Pipeline completata con successo.'
            sh """
                    curl -X POST \
                    https://api.telegram.org/bot"iserisci_token_leva_le_virgolette"/sendMessage \
                    -H "Content-Type: application/json" \
                    -d '{"chat_id": "inserisci_chatID", "text": "Ciao, la pipeline è riuscita"}'
                    """
        }
        failure {
            echo 'Pipeline fallita.'
                    sh """
                    curl -X POST \
                    https://api.telegram.org/bot"iserisci_token_leva_le_virgolette"/sendMessage \
                    -H "Content-Type: application/json" \
                    -d '{"chat_id": "inserisci_chatID", "text": "Ciao, la pipeline è fallita"}'
                    """
        }
    }
}
