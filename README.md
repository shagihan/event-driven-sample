# event-driven-sample

This is a very basic example of event driven architecture. 

## Configurations

Configure the database as well as the RabbitMQ (Message broker) related configurations in the **application.yaml** file.

#### Sample config provided
```spring:
    main:
        allow-bean-definition-overriding : true
        datasource:
        driver-class-name: com.mysql.cj.jdbc.Driver
        url: jdbc:mysql://localhost:3306/spring_rest_jpa_db
        username: root
        password: root
    jpa:
        show-sql: true
    hibernate:
        ddl-auto: create-drop
    rabbitmq:
        host: localhost
        port: 5672
        username: admin
        password: admin
springrestjpa:
    rabbitmq:
        queue: async.test.queue
        exchange: async.test.exchange
        routingkey: async.test.routingkey
```

## Build instructions

use maven build command to build the project.

```
mvn clean install
```
