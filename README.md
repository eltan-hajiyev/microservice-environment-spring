# **Microservice environment with Spring Boot and Docker**

**Discovery service**
>- docker pull consul
>- docker run -d --name=dev-consul  consul

**Authorization service**
>- ./mvnw clean install
>- docker build -t springio/authorization .
>- docker run -d -p 8080:8080 --network=bridge springio/authorization

**Message service**
>- ./mvnw clean install
>- docker build -t springio/message-service .
>- docker run -d -p 8080:8080 --network=bridge springio/message-service

**Account service**
>- ./mvnw clean install
>- docker build -t springio/account .
>- docker run -d -p 8080:8080 --network=bridge springio/account



