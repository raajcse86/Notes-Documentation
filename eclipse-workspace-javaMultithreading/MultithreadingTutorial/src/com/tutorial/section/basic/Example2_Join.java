package com.tutorial.section.basic;


class Runner1Join implements Runnable{
	
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("Runner1 "+i);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}

class Runner2Join implements Runnable{
	
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("Runner2 "+i);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}


public class Example2_Join {

	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runner1Join());
		Thread t2 = new Thread(new Runner2Join());
		t1.start();
		t2.start();
		
		try {
			t1.join();
			//t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Main Thread finished");
		
		
		//comments:
		//both t1 and t2 share the memory and run, with join on t1 we make sure that the 
		//we are waiting for t1 to die and then allowing to run statement after that.
		//as in the above example t1 has 10 iteration and t2 has 100 iteration, so statement after join
		//printed as soon as t1 finished, it did not wait for t2 to finish as we have applied
		//join only on t1.
		
		
	}
}
