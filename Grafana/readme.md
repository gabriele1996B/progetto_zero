Creazione docker grafana. 
```bash
sudo touch docker-compose.yml
```
All’interno della cartella docker-compose.yml lanciare il seguente comando per avviare docker, e tenerlo attivo in background.
```bash
sudo docker compose up -d
```
Installare prometheus sulla VM e configurarlo. 
```
seguire la seguente guida ---> https://www.cherryservers.com/blog/install-prometheus-ubuntu
```
Provare query sulla gui accessibile attraverso sito web http://vm:9090/
```
avg by (instance) (irate(process_cpu_seconds_total{job="prometheus"}[1m]))
```
Entrare nel seguente link
```bash
http://localhost:3000
```

su Grafana creata una nuova connessione prometheus e una dashboard di monitoraggio con la query di sopra che monitora la cpu utilizzata da prometheus all’interno della VM.
