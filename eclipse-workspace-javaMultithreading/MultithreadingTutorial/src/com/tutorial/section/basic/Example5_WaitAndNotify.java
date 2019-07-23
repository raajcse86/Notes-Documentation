package com.tutorial.section.basic;


//As both the methods are locking on object level, t1 starts produce, t2 starts consume
//as t2 sleeps for 1000,t1 acquires lock, then it call wait(), so the lock released
//t2 acquires the lock, it runs, it calls notify, now again t1 runs.
//but if there are some statements after notify in the method where t2 was there, it 
//will first execute those statements.
class Processor{
	
	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("We are in Producer.");
			wait();
			System.out.println("Again we are in producer");
		}
	}
	
	public void consume() throws InterruptedException {
		Thread.sleep(1000);
		synchronized (this) {
			System.out.println("We are in Consumer.");
			notify();
			System.out.println("Still in consumer -after notify");
			Thread.sleep(3000);
			
		}
	}
}



public class Example5_WaitAndNotify {

	
	public static void main(String[] args) throws InterruptedException {
		Processor processor = new Processor();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
			try {
				processor.produce();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
			try {
				processor.consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
		});
		
		
		t1.start();
		t2.start();
		
		
		t1.join();
		t2.join();
	}
	
	
	
	
	
}
