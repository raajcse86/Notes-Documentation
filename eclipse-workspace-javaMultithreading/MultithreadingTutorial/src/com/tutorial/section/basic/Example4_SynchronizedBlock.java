package com.tutorial.section.basic;

public class Example4_SynchronizedBlock {

	private  static int counter = 0;

	public static synchronized void increment() {
		counter++;
		
	}
	public  void process() {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					increment();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					increment();
				}

			}
		});

		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new Example4_SynchronizedBlock().process();
		System.out.println("Main Thread finished" +counter);

	}
}
