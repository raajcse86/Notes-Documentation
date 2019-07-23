package com.kafka.tutorial.firstdemo;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class ProducerDemoKeys {

    private static final Logger logger = LoggerFactory.getLogger(ProducerDemoKeys.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //System.out.println("HelloWorld");
        String bootsrapservers = "127.0.0.1:9092";
        //create producer properties
        Properties prop = new Properties();
        prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootsrapservers);
        prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());

        //create producer

        KafkaProducer<String,String> producer = new KafkaProducer<String, String>(prop);


        for(int i=0;i<10;i++) {
            //send data - asynchronous.
            String topic = "first_topic";
            String value = "helloworld" + Integer.toString(i);
            String key = "id_"+Integer.toString(i);

            System.out.println("Key is "+key);
            ProducerRecord<String,String> record = new ProducerRecord<String, String>(topic,key,value);

            producer.send(record, new Callback() {
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    //executes every time when the data sent successfully or an exception is thrown.
                    if (recordMetadata != null) {
                        System.out.println("Received new metadata \n" +
                                "Topic : " + recordMetadata.topic() + "\n" +
                                "Partition :" + recordMetadata.partition() + "\n" +
                                "OffSet :" + recordMetadata.offset() + "\n" +
                                "TimeStamp :" + recordMetadata.timestamp()
                        );
                    } else {
                        System.out.println("Error while producing");
                    }
                }
            }).get(); // block the send() to make it syunchronoud
            //flush data
            producer.flush();


        }

        //flush and close the producer.
        producer.close();

        //when you send the messages with keys it always goes to same partition.
        //result
        //id_0 goes to partition 1
        //id_1 to 0
        //id_2 to 2
        //id_3 to 0
        //id_4 to 2
    }


}
