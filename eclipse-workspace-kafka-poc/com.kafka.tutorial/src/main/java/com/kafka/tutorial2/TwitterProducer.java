package com.kafka.tutorial2;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.twitter.hbc.ClientBuilder;
import com.twitter.hbc.core.Client;
import com.twitter.hbc.core.Constants;
import com.twitter.hbc.core.Hosts;
import com.twitter.hbc.core.HttpHosts;
import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.core.processor.StringDelimitedProcessor;
import com.twitter.hbc.httpclient.auth.Authentication;
import com.twitter.hbc.httpclient.auth.OAuth1;

public class TwitterProducer {
	
	Logger logger = LoggerFactory.getLogger(TwitterProducer.class);

	String consumerKey = "3vdG6Qv3toP4jU89kQEM1fj41";
	String consumerSecret = "Ghq1AM9tpHJABPPFM86tWmB3EqNU0zH9RS9J7XHczOtVAZ0yMw";
	String token = "1052435594733912065-AsD6oOc6mHjxxTnLVNWvseHhwc0ypb";
	String secret = "K5hFMV59YURfQTcIfksG5AWgq1BSczG2kGjBGRDdoRYp5";
			
	public static void main(String[] args) {
		//create twitter client
		//create kafka producer
		//loop to send tweets to kafka
		new TwitterProducer().run();
		
		
		
	}
	
	
	public void run() {
		logger.info("set up...");
		/** Set up your blocking queues: Be sure to size these properly based on expected TPS of your stream */
		BlockingQueue<String> msgQueue = new LinkedBlockingQueue<String>(100000);
		Client client = createTwitterClient();
		client.connect();
		// on a different thread, or multiple different threads....
		
		KafkaProducer<String, String> producer = createKafkaProducer();
		
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
				logger.info("Stopping the application");
				logger.info("shutting down client from twitter");
				
				client.stop();
				logger.info("Closing producer");
				producer.close();
		}));
		
		while (!client.isDone()) {
			String msg =null;
		try {
			msg= msgQueue.poll(5,TimeUnit.SECONDS);
		}catch(InterruptedException e) {
			e.printStackTrace();
			client.stop();
		}
		if(msg != null) {
			logger.info(msg);
			producer.send(new ProducerRecord<>("twitter_tweets",null,msg), new Callback() {
				@Override
				public void onCompletion(RecordMetadata arg0, Exception e) {
					
					if(e != null) {
						logger.error("something wrong has happened",e);
					}
				}
			});
		}
		  
		}
		logger.info("End of application");;
	}
	
	public Client createTwitterClient() {
		/** Set up your blocking queues: Be sure to size these properly based on expected TPS of your stream */
		BlockingQueue<String> msgQueue = new LinkedBlockingQueue<String>(100000);
		
		/** Declare the host you want to connect to, the endpoint, and authentication (basic auth or oauth) */
		Hosts hosebirdHosts = new HttpHosts(Constants.STREAM_HOST);
		StatusesFilterEndpoint hosebirdEndpoint = new StatusesFilterEndpoint();
		// Optional: set up some followings and track terms
		//List<Long> followings = Lists.newArrayList(1234L, 566788L);
		List<String> terms = Lists.newArrayList("bitcoin","kafka","usa","cricket");
		//hosebirdEndpoint.followings(followings);
		hosebirdEndpoint.trackTerms(terms);

		// These secrets should be read from a config file
		Authentication hosebirdAuth = new OAuth1(consumerKey, consumerSecret, token, secret);
		
		//Creating a client:

			ClientBuilder builder = new ClientBuilder()
			  .name("Hosebird-Client-01")                              // optional: mainly for the logs
			  .hosts(hosebirdHosts)
			  .authentication(hosebirdAuth)
			  .endpoint(hosebirdEndpoint)
			  .processor(new StringDelimitedProcessor(msgQueue));

			Client hosebirdClient = builder.build();
			// Attempts to establish a connection.
			//hosebirdClient.connect();
			return hosebirdClient;
	}
	
	public KafkaProducer<String, String> createKafkaProducer(){
		String bootsrapservers = "127.0.0.1:9092";
        //create producer properties
        Properties prop = new Properties();
        prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootsrapservers);
        prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());

        //create a safe producer properties
        prop.setProperty(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");
        prop.setProperty(ProducerConfig.ACKS_CONFIG, "all");
        prop.setProperty(ProducerConfig.RETRIES_CONFIG, Integer.toString(Integer.MAX_VALUE));
        prop.setProperty(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, "5");
        
        //high troughput producer at the expense of bit cpu usage and latency.
        prop.setProperty(ProducerConfig.COMPRESSION_TYPE_CONFIG, "snappy");
        prop.setProperty(ProducerConfig.LINGER_MS_CONFIG, "20");
        prop.setProperty(ProducerConfig.BATCH_SIZE_CONFIG, Integer.toString(32 * 1024));//this is 32kb setting
        
        //create producer
        KafkaProducer<String,String> producer = new KafkaProducer<String, String>(prop);
        ProducerRecord<String,String> record = new ProducerRecord<String, String>("first_topic","helloworld");
        

        //send data - asynchronous.
        producer.send(record);

        //flush data
        producer.flush();

        //flush and close the producer.
        producer.close();
        return producer;
	}
}
