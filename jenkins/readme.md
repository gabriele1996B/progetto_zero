1) Installare Jenkins all'interno di un container
```bash
docker run -–net=host -p 8080:8080 -p 50000:50000 jenkins/jenkins:lts
```
2) Accedere all'interfaccia web attraverso questo indirizzo http://localhost:8080

3) Seguire il processo di autenticazione. La password si trova all'interno del percorso qui sotto. Ricordarsi di essere all'interno del container.
```bash
/var/jenkins_home/secrets/initialAdminPassword
```

4) Proseguire con l'installazione dei componenti consigliati.

5) Creare utente "Jenkins" all'interno della macchina virtuale. Inserire l'utente Jenkins all'interno del gruppo docker in modo da bypassare l'utilizzo del comando sudo.
   ```bash
   sudo useradd -m -d /home/jenkins -s /bin/bash jenkins
   sudo passwd jenkins
   ```

6) Installare Java, e configurare il path.

6a) Modificare il file /etc/profile attraverso questo comando
```bash
sudo vim /etc/profile
```

6b) In fondo allo scritp copiare in sequenza questi due variabili:
```bash
    JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
    export PATH=$PATH:/usr/lib/jvm/java-17-openjdk-amd64/bin
```

7) Creare un nuovo nodo chiamato "docker" all'interno delle impostazioni della gui di Jenkins.

8) Settare queste impostazioni in questo modo:

  • Directory radice remota: /var/jenkins
  
  • Metodo di avvio: con SSH (con credenziali dell’utente creato sulla VM)
  
  • Avanzate – JavaPath: /usr/bin/java


La pipeline prevede 3 stage (pul, build, deploy) che copia il dockerfiles e lo script, e lo scarica direttamente dentro la VM permettendo l’esecuzione dello script attraverso.
Che vada in errore o no, verrà inviato un messaggio di testo al proprio telegram.
