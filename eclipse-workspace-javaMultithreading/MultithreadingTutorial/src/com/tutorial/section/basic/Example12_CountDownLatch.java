package com.tutorial.section.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Task implements Runnable{
	
	private int id;
	private CountDownLatch countDownLatch;
	
	Task(int id, CountDownLatch countDownLatch){
		this.id = id;
		this.countDownLatch = countDownLatch;
				
	}
	
	@Override
	public void run() {
		System.out.println("Thread with id "+this.id+ " starts working.");
		countDownLatch.countDown();
	}
	

}


public class Example12_CountDownLatch {


	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		CountDownLatch countDownLatch = new CountDownLatch(5);
		for(int i=0;i<5;i++) {
			executorService.submit(new Task(i, countDownLatch));
		}
		
		countDownLatch.await();
		System.out.println("All the tasks are done. Now we can collaborate them");
		executorService.shutdown();

	}

}
