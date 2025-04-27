# RabbitmQ
Project to demonstrate Rabbitmq with springboot

# Install RabbitMQ in MAC
* Install Brew 
* Install RabbitMQ (brew install rabbitmq)
* Install Erlang/OTP

# Start RMQ in MAC
* brew services start rabbitmq

# Start RMQ in MAC
* brew services stop rabbitmq

# RabbitMQ Client Dependencies
<dependency>
    <groupId>com.rabbitmq</groupId>
    <artifactId>amqp-client</artifactId>
    <version>5.25.0</version>
</dependency>

# Dependency for actuator
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

# Connection Factory
* can be created via class 
* or, can be added in application.yml / application.properties

