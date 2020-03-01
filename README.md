# **Microservice environment with Spring Boot and Docker**

 **Internal service:**
 Interface for all shared services we hold in one project. First you need add "internal-service-payday" project to local repository. In order to do that you should call next command. 
 We overrided @org.springframework.web.bind.annotation.RequestMapping and created @InternalService annotation. All internal servicel have "/internal/\*\*" path. For security, we have denyAll() for this path in zuul project.
>- ./mvnw clean instsll

**Discovery service**:
You should start "consul" (discovery service) for register microservices.
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
