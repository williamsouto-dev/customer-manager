# build project with maven
mvn -f pom.xml clean package

# run prometheus, grafana, postgre, kafka and finally the main service
docker-compose up -d
