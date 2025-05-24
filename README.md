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

# Publisher setup
# Cosumer setup

# Publishing JSON message to Queue

* Dependency
<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-json -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-json</artifactId>
    <version>3.4.5</version>
</dependency>

* In RabbitMQConfig make the necessry changes for conversion to JSON

# Created a DirectExchange with name "Direct Exchange"
* created Queue Mobile,TV, AC
* added the binding for each queue with it's routing key mobile,tv,ac respectively.

# Created a FanOut Exchange with name "Fanout-Exchange"
* Binding the Fanout-Exchange to Mobile and AC queue and not TV queue

# Created a Topic Exchange with name "Topic-Exchange"
* created the binding for Mobile queue, with routing key as "*.mobile.*"
* created the binding for TV queue, with routing key as "*.tv.*"
* created the binding for AC queue, with routing key as "#.ac."
