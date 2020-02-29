# **Microservice environment with Spring Boot and Docker**

**Discovery service**
>- docker pull consul
>- docker run -d --name=dev-consul -e CONSUL_BIND_INTERFACE=eth0 consul

**Authorization service**
>- ./mvnw clean install
>- docker build -t springio/authorization .
>- docker run -d springio/authorization

**Message service**
>- ./mvnw clean install
>- docker build -t springio/message-service .
>- docker run -d springio/message-service

**Account service**
>- ./mvnw clean install
>- docker build -t springio/account .
>- docker run -d springio/account


**Zuul gateway service**
>- ./mvnw clean install
>- docker build -t springio/gateway-service .
>- docker run -d -p 8080:8080 springio/gateway-service
