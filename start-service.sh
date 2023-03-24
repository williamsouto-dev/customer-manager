# build project with maven
mvn -f pom.xml clean package

# build image project
sudo docker build -t customer-manager:latest .

# run prometheus, grafana and postgre
sudo docker-compose up -d

# run service in a docker container
sudo docker run -p 8088:8088 customer-manager:latest
