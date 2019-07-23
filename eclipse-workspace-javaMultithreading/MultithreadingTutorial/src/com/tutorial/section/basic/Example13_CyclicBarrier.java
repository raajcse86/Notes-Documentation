package com.tutorial.section.basic;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//After all the threads finished, the cyclic barrier which implements run() at the client will execute.
//after cyclic barrier task in the client, the statement after barrier.await() in the run method
//will run for all the five threads.

class WorkerCyclic implements Runnable{
	
	private int id;
	private Random random;
	private CyclicBarrier cyclicBarrier;
	
	WorkerCyclic(int id, CyclicBarrier cyclicBarrier){
		this.id = id;
		random = new Random();
		this.cyclicBarrier = cyclicBarrier;
				
	}
	
	@Override
	public void run() {
		
		doWork();
	}

	private void doWork() {
		System.out.println("Thread with id "+this.id+ " starts working.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Thread with id "+this.id+ " finished working");
		
		try {
			cyclicBarrier.await();
			//After the task are finished.
			System.out.println("After task finished");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		
	}
	
	
	

}

public class Example13_CyclicBarrier {


	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {
			@Override
			public void run() {
				System.out.println("All the task are finished...");
			}
		});
		
		for(int i=0;i<5;i++) {
			executorService.submit(new WorkerCyclic(i+1, barrier));
		}
		
		System.out.println("Befor shutdown");
		executorService.shutdown();

	}

}
