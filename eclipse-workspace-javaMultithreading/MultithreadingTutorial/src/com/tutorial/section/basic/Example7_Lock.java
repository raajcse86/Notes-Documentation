package com.tutorial.section.basic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//you just have to call lock() and then unlock method in the finally block.
//it is similar to synchronized block.
//little more control is that we call unlock even based on any condition.

public class Example7_Lock {

	private static int count = 0;
	private static Lock lock = new ReentrantLock();

	public static void increment() {

		lock.lock();
		try {
			for (int i = 0; i < 1000; i++) {
				count++;
			}
		} finally {
			lock.unlock();
		}

	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				increment();

			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				increment();

			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println("Counter >> " + count);
	}

}
