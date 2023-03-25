# customer-manager

<hr/>

### Example microservice using hexagonal architecture and resources aws

The service is a simple example that use several resources available in a framework spring boot, api, messenger and AWS.

Below is a list of technologies used:

- Docker (Docker Compose and Dockerfile)
- Prometheus 
- Grafana
- Postgres
- kafka
- AWS
- Java 11
- Spring boot(JPA, OpenApi, Lombok, Feign)
- Spring Security with JWT
- Junit

![Prometheus](https://img.shields.io/badge/Prometheus-E6522C?style=for-the-badge&logo=Prometheus&logoColor=white)
![Grafana](https://img.shields.io/badge/grafana-%23F46800.svg?style=for-the-badge&logo=grafana&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Apache Kafka](https://img.shields.io/badge/Apache%20Kafka-000?style=for-the-badge&logo=apachekafka)
![AWS](https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)

<hr/>

### About Service

Two use cases were developed to allow a greater chance to use various features and try to approach real problems.
Both flows have a validation and approval.

Registrations are possible via API and approval is performed by asynchronous flow via messaging.

### Start Project

The service was developed with docker, so spring boot, database, kafka, prometheus and grafana are containerized services.
In the root of the project there is a sh file called `start-service.sh` which will start all the services needed to run the project.

run the command in your terminal:

`sh start-service.sh`

After that open browser and put url `localhost:8088/swagger-ui.html`