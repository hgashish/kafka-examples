## Getting started

### Starting Kafka in local
1. Install `docker` and `docker-compose`
     * https://docs.docker.com/install/
     * https://docs.docker.com/compose/install/

2. Clone this repo

    `git clone https://github.com/hgashish/kafka-boilerplate.git`

3. Provide execute permission to `startKafka.sh`
    
    `chmod +x startKafka.sh`
    
4. Connect to local kafka using bootstrap server url `localhost:9092`

5. To create and view available topics 
    * Connect to Kafka container
    
        `docker exec -it {containerId} /bin/sh`
        
        Replace `{containerId}` with actual container id. 
    * To list all the topics, run this in Kafka container
    
        `kafka-topics --list --bootstrap-server localhost:9092`
    * To create topic
    
        `kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 2 --topic {topicName}`
        
        Replace `{topicName}` in the above command with actual topic name to be created.
    * Alternatively https://www.kafkatool.com/ can be used to create & list topics, view data.