# customer-manager

<hr/>

### Example microservice using hexagonal architecture and resources aws

The service is a simple example that use several resources available in a framework spring boot, api, messenger and AWS.


<p>The project is structured as follows:</p>
<pre>├── <font color="#E87056"><b>adapter</b></font>
│   ├── <font color="#0883FF"><b>in</b></font>
│   │   └── <font color="#0883FF"><b>controller</b></font>
│   │       └── <font color="#0883FF"><b>dto</b></font>
│   └── <font color="#0883FF"><b>out</b></font>
│       └── <font color="#0883FF"><b>metrics</b></font>
├── <font color="#E87056"><b>application</b></font>
│   └── <font color="#0883FF"><b>in</b></font>
├── <font color="#E87056"><b>commons</b></font>
│   ├── <font color="#0883FF"><b>enums</b></font>
│   └── <font color="#0883FF"><b>exception</b></font>
└── <font color="#E87056"><b>domain</b></font>
    └── <font color="#0883FF"><b>validation</b></font>
</pre>

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

#### requirements

- Java 11 (sudo apt-get install openjdk-11-jdk)
- [Docker](https://docs.docker.com/engine/install/ubuntu/)
- Docker Compose (sudo apt install docker-compose)


The service was developed with docker, so spring boot, database, kafka, prometheus and grafana are containerized services.
In the root of the project there is a sh file called `start-service.sh` which will start all the services needed to run the project.

run the command in your terminal:

`sh start-service.sh`

Services url:

* [Service Customer Manager - Swagger](http://localhost:8088/swagger-ui.html)
* [Prometheus](http://localhost:9090)
* [Grafana](http://localhost:3000)

<a href="https://i.postimg.cc/qMyk7rLC/2-prometheus.png"><img src="https://i.postimg.cc/qMyk7rLC/2-prometheus.png" width="200" height="120" alt="Grafana"/></a>
<a href="https://i.postimg.cc/8krGyGxn/4-grafana.png"><img src="https://i.postimg.cc/8krGyGxn/4-grafana.png" width="200" height="120" alt="Grafana"/></a>

### Optional - View metrics in grafana

<p>Prometheus monitors the spring boot application. Grafana views Prometheus as a data source.</p>

<p>Open the <a href="http://localhost:3000/">Grafana</a> link and on the login screen, enter the <i>admin-admin credentials</i></p>

<p>
    Steps

- Configure data sources: Click Configuration -> Data Sources
    - Click add data source -> Prometheus
    - Fill in the fields with the following parameters and click Save & test:


| Field  |         Value          |
|:-------|:----------------------:|
| URL    | http://prometheus:9090 |
| Access |        Browser         |
| Http   |          GET           |

_Other parameters can be left with default value. According to the attached print_

- Import Dashboard: Click on Dashboards -> Browse -> Import -> Upload JSON file
    - Select the json file in the project root called board-grafana.json.
    - Select the newly configured Prometheus data source and click Import.

_All steps are attached in order_

</p>


<a href="https://i.postimg.cc/8krGyGxn/4-grafana.png"><img src="https://i.postimg.cc/8krGyGxn/4-grafana.png" width="150" height="80" alt="Grafana"/></a>
<a href="https://i.postimg.cc/3xZYgZz8/5-grafana.png"><img src="https://i.postimg.cc/3xZYgZz8/5-grafana.png" width="150" height="80" alt="Grafana"/></a>
<a href="https://i.postimg.cc/T2ydZg50/6-grafana.png"><img src="https://i.postimg.cc/T2ydZg50/6-grafana.png" width="150" height="80" alt="Grafana"/></a>
<a href="https://i.postimg.cc/RhJDXMF1/7-grafana.png"><img src="https://i.postimg.cc/RhJDXMF1/7-grafana.png" width="150" height="80" alt="Grafana"/></a>
<a href="https://i.postimg.cc/bvN8LtjQ/8-grafana.png"><img src="https://i.postimg.cc/bvN8LtjQ/8-grafana.png" width="150" height="80" alt="Grafana"/></a>
<a href="https://i.postimg.cc/j5Bbs3nX/9-grafana.png"><img src="https://i.postimg.cc/j5Bbs3nX/9-grafana.png" width="150" height="80" alt="Grafana"/></a>
<a href="https://i.postimg.cc/R0smYZM2/10-grafana.png"><img src="https://i.postimg.cc/R0smYZM2/10-grafana.png" width="150" height="80" alt="Grafana"/></a>
<a href="https://i.postimg.cc/Y9v7BB00/11-grafana.png"><img src="https://i.postimg.cc/Y9v7BB00/11-grafana.png" width="150" height="80" alt="Grafana"/></a>
<a href="https://i.postimg.cc/D0sKmQqK/12-grafana.png"><img src="https://i.postimg.cc/D0sKmQqK/12-grafana.png" width="150" height="80" alt="Grafana"/></a>
<a href="https://i.postimg.cc/HkTCsynf/13-grafana.png"><img src="https://i.postimg.cc/HkTCsynf/13-grafana.png" width="150" height="80" alt="Grafana"/></a>
<a href="https://i.postimg.cc/5NBVV34B/14-grafana.png"><img src="https://i.postimg.cc/5NBVV34B/14-grafana.png" width="150" height="80" alt="Grafana"/></a>
<a href="https://i.postimg.cc/c1w947CT/board.png"><img src="https://i.postimg.cc/c1w947CT/board.png" width="150" height="80" alt="Grafana"/></a>

<hr>