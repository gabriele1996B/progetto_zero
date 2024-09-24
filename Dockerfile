#from prende l'immagine come base
FROM alpine:latest
#run è utilizzato per eseguire un comando durante la build
RUN apk update
RUN apk add bash
#COPY serve a copiare il file
COPY ./TO_DO_LIST /home/
#CMD esegue i comandi quando si avvia il container
CMD ["bash", "/home/TO_DO_LIST"]
