package com.tutorial.section.basic;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class FirstWorker implements Runnable{
	
	BlockingQueue<Integer> blockingQueue;
	
	public FirstWorker(BlockingQueue<Integer> queue) {
		this.blockingQueue = queue;
	}
	
	@Override
	public void run() {
		int count =1;
		while(true){
			try {
				System.out.println("Adding to Queue "+count);
				blockingQueue.put(count);
				count++;
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}


class SecondWorker implements Runnable{
	
	BlockingQueue<Integer> blockingQueue;
	
	public SecondWorker(BlockingQueue<Integer> queue) {
		this.blockingQueue = queue;
	}
	
	@Override
	public void run() {
		while(true){
			try {
				int number = blockingQueue.take();
				System.out.println("Taking from Queue "+number);
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}

public class Example14_BlockingQueue {

	public static void main(String[] args) {
		BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);
		
		Thread t1 = new Thread(new FirstWorker(blockingQueue));
		Thread t2 = new Thread(new SecondWorker(blockingQueue));
		
		t1.start();
		t2.start();
	}
}
