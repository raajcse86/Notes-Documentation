package com.tutorial.section.basic;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//you just have to call lock() and then unlock method in the finally block.
//it is similar to synchronized block.
//little more control is that we call unlock even based on any condition.
//condition.await is similar to wait(), 
//condition.signal is similar to notify()
class Worker {
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void produce() throws InterruptedException {
		lock.lock();
		System.out.println("Producer method..");
		condition.await();
		System.out.println("Producer again");
		lock.unlock();

	}

	public void consume() throws InterruptedException {
		lock.lock();
		Thread.sleep(2000);
		System.out.println("Consumer method");
		condition.signal();
		System.out.println("Consumer again");
		lock.unlock();
	}

}

public class Example9_Semaphore {

	public static void main(String[] args) throws InterruptedException {
		Worker worker = new Worker();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					worker.produce();
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
					worker.consume();
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
