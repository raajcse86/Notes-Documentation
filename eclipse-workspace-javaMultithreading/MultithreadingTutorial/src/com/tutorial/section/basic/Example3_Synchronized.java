package com.tutorial.section.basic;


///instead applying synchronized at the method level, put it in the block.
//because inside the block you can lock on a particular object, so that
//two threads can access.
// In Method level the lock applied for entire class level,  so that add() and addAgain()
//cannot run simultaneously .
//that is if t1 access add(), even t2 cannot access addAgain() though both are different methods
// and doing different operations, because the intrinsic lock at class level is acquired by one thread
//other thread has to wait.
public class Example3_Synchronized {

	private  static int counter1 = 0;
	private  static int counter2 = 0;
	
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();

	public static  void add() {
		synchronized(lock1) {
			counter1++;	
		}
	}
	
	public static  void addAgain() {
		synchronized(lock2) {
			counter2++;	
		}
		
		
	}
	
	public static void compute() {
		for(int i=0;i<100;i++) {
			add();
			addAgain();	
		}
		
	}
	
	
	public  static void process() {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				compute();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				compute();

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
		process();
		System.out.println("Counter1 >> " +counter1 +"Counter 2 >> "+counter2);

	}
}
