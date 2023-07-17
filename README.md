
<p align="center">
  <a href="https://quarkus.io" target="blank"><img src="https://design.jboss.org/quarkus/logo/final/SVG/quarkus_logo_horizontal_rgb_default.svg" width="500" alt="Quarkus Logos" /></a>
</p>
<p align="center"><a href="https://quarkus.io/" target="_blank">Quarkus</a> è un framework Java Kubernetes native full-stack, realizzato per le macchine virtuali Java (JVM) e per la compilazione nativa. Il framework ottimizza Java specificamente per i container, trasformandolo in una piattaforma efficiente per ambienti serverless, cloud e Kubernetes.</p> <p align="center">

## Avvio dell'applicazione

<a href="https://www.docker.com/" target="blank"><img src="https://www.docker.com/wp-content/uploads/2022/03/Moby-logo.png" alt="Logo Docker" width="300" height="180"></a>

Per avviare l'applicazione, è necessario eseguire il seguente comando:

```shell
> docker-compose up --detach
```
Il seguente utilizza il Docker Compose, per creare e avviare i contenitori richiesti per l'esecuzione dell'applicazione.

## Modifica del file docker-compose.yml

Se desideri avviare l'applicazione utilizzando OpenJDK, assicurati che l'istruzione `dockerfile` sia impostata su `Dockerfile` come segue:

    ```
    build:
      context: .
      dockerfile: Dockerfile
    ```

Se invece desideri avviare l'applicazione utilizzando GraalVM, cambia l'istruzione `dockerfile` in `Dockerfile.graalvm` come segue:

    ```
    build:
      context: .
      dockerfile: Dockerfile.graalvm
    ```

## Documentazione

- [Docker](https://www.docker.com/)
- [Documentazione Docker](https://docs.docker.com/)
- [Guida utente di Quarkus](https://quarkus.io)
- [Riferimento di configurazione di Quarkus](https://quarkus.io/get-started/)
- [Guide di Quarkus](https://quarkus.io/guides/)

## Autore

- Autore - [Giuseppe Cicchella](https://github.com/gcicchella)
