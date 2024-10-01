Quando utilizzi Docker Swarm per orchestrare un container, il primo passo è inizializzare uno Swarm. 
Questo processo crea un cluster di nodi Docker, e il nodo su cui esegui l'inizializzazione diventa il nodo manager. 
Esegui questo comando sul nodo che vuoi rendere manager.

```bash
sudo docker swarm init
```
Se Docker Swarm viene inizializzato correttamente, otterrai un messaggio simile a questo:
```
Swarm initialized: current node (xxxxxxxxxxxx) is now a manager.
To add a worker to this swarm, run the following command:
docker swarm join --token <TOKEN> <MANAGER-IP>:2377
```
Questo comando ti dà un token che userai per aggiungere altri nodi come worker al cluster Swarm.

Puoi verificare lo stato dello Swarm sul nodo manager con il seguente comando
```bash
sudo docker node ls
```
Docker Swarm funziona creando servizi, che sono versioni distribuite di container Docker. 
```bash
sudo docker service create --name my-cont --replicas 2 image_todolist
```
Per vedere lo stato dei servizi, esegui:
```bash
sudo docker service ls
```
Per vedere i dettagli di un servizio specifico, eseguire questo comando:
```bash
sudo docker service ps my-cont
```
Puoi aggiornare facilmente un servizio già in esecuzione attraverso questo comando. Ad esempio, per scalare il numero di repliche a 5:
```bash
sudo docker service scale my-cont=5
```
Per aggiornare l'immagine del servizio con una nuova versione:
```bash
docker service update --image image_todolist2 my-cont
```
Per rimuovere un servizio:
```bash
sudo docker service rm my-cont
```
Creare un docker-compose.yml per creare stack, ovvero insieme di servizi definiti dal file .yml
```bash
version: '3'
services:
  web:
    image: to_do_list
    ports:
      - "80:80"
```
Per distribuire lo stack:
```bash
docker stack deploy -c docker-compose.yml my-stack
```
Per verificare lo stato dello stack: 
```bash
sudo docker stack ls
```


















