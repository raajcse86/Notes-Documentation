package com.kafka.tutorial.firstdemo;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerDemoAssignAndSeek {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerDemoAssignAndSeek.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        String bootsrapservers = "127.0.0.1:9092";
        String topic = "first_topic";

        //create consumer properties
        Properties prop = new Properties();
        prop.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootsrapservers);
        prop.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        prop.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        //earliest - from beginning, latest - latest, none - none
        prop.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");


        //create Consumer.

        KafkaConsumer<String,String> consumer = new KafkaConsumer<String, String>(prop);

        
        //assign and seek - used to fetch a specific message
        TopicPartition partitionToReadFrom = new TopicPartition(topic, 0);
        long offsetToReadFrom = 15L;
        consumer.assign(Arrays.asList(partitionToReadFrom));
        consumer.seek(partitionToReadFrom,offsetToReadFrom);
        int numberOfMessagsToRead = 5;
        boolean keepReading = true;
        int numberOfMessagesReadSoFar = 0;
        
        		
        
        //consumer.subscribe(Collections.singleton(topic));

        while(keepReading){
            ConsumerRecords<String,String> records = consumer.poll(Duration.ofMillis(100));
            for(ConsumerRecord<String,String> record:records ) {
            	numberOfMessagesReadSoFar+=1;
            	logger.info("key "+record.key()+" value "+record.value());
            	logger.info("Partition "+record.partition()+" offset "+record.offset());
            	if(numberOfMessagesReadSoFar >=numberOfMessagsToRead) {
            		keepReading =false;
            		break;
            	}
            }
        }
    }
}
