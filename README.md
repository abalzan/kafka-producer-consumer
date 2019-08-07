# Kafka producer and consumer sample

This is just a simple sample of producer and consumer using kafka.

### Install kafka
https://www.apache.org/dyn/closer.cgi?path=/kafka/2.3.0/kafka_2.12-2.3.0.tgz

### Running Kafka

#### Stating Zookeeper server
kafka/bin/zookeeper-server-start.sh config/zookeeper.properties

#### Starting Kafka server
kafka/bin/kafka-server-start.sh config/server.properties

#### getting the params passing thought request
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic TopicNameHere

