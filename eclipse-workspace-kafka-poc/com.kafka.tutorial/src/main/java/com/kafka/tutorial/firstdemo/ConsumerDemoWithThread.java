package com.kafka.tutorial.firstdemo;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerDemoWithThread {

	private static final Logger logger = LoggerFactory.getLogger(ConsumerDemoWithThread.class);

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		new ConsumerDemoWithThread().run();
	}
	
	public void run() {
		CountDownLatch latch= new CountDownLatch(1);
		String bootsrapservers = "127.0.0.1:9092";
		String group_id = "my_sixth_group";
		String topic = "first_topic";
		ConsumerThread consumerThread = new ConsumerThread(latch,bootsrapservers,group_id,topic);
		Thread myThread = new Thread(consumerThread);
		myThread.start();
		
		//add a shutdown hook
		Runtime.getRuntime().addShutdownHook(new Thread(()-> {
			logger.info("Caught shutdown hook");
			consumerThread.shutDown();
			try {
				latch.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			logger.info("Application has exited");
			
		}));
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			logger.error("Application got interrupted",e);
		}
		finally {
			logger.info("Application is closing");
		}
	}

	public class ConsumerThread implements Runnable {
		private CountDownLatch latch;
		private KafkaConsumer<String, String> consumer;

		public ConsumerThread(CountDownLatch latch, String bootStrapServers, String groupId, String topic) {
			Properties prop = new Properties();
			prop.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServers);
			prop.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
			prop.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
			prop.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
			// earliest - from beginning, latest - latest, none - none
			prop.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
			this.latch = latch;
			consumer = new KafkaConsumer<>(prop);
			consumer.subscribe(Arrays.asList(topic));
		}

		@Override
		public void run() {
			try {
				while (true) {
					ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
					for (ConsumerRecord<String, String> record : records) {
						logger.info("key " + record.key() + " value " + record.value());
						logger.info("Partition " + record.partition() + " offset " + record.offset());
					}
				}
			}catch(WakeupException e){
				logger.info("Received shutdown signal");
			}finally {
				consumer.close();
				//tell our main code we are done with the consumer
				latch.countDown();
			}
			

		}
		
		public void shutDown() {
			//the wakeup is a special method to interrupt poll.
			/// it will throw wake up exception
			consumer.wakeup();
		}

	}
}
