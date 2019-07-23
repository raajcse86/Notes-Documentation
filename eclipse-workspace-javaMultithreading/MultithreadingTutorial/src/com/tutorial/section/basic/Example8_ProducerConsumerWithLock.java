package com.tutorial.section.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

//semaphore is used to hold the count of resource that can be accessed simultaneously.
//here it is 3 resource can access at a time.
//like connection object to DB.
//It has acquire and release method
//with acquire method it can keep track of count of number of resources,
//whenever it releases it decrement the count.
enum Downloader {
	
	INSTANCE;
	
	private Semaphore semaphore = new Semaphore(3, true);
	
	
	public void downloadData() {
		try {
			semaphore.acquire();
			download();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			semaphore.release();
		}
	}
	
	private void download() {
		System.out.println("Download from web.....");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}

public class Example8_ProducerConsumerWithLock {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		for(int i=0;i<12;i++) {
			executorService.submit(()->Downloader.INSTANCE.downloadData());
		}

	}

}
