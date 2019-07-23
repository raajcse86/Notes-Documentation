package com.tutorial.termination;

public class Main1 {
	 public static void main(String [] args) {
	        Thread thread = new Thread(new BlockingTask());
	        thread.start();
	        
	        // interrupting intentionly,but if the thread is running in the loop it will not stop let the application to stop..
	        //once an InterruptedException is caught, inside that you can return statement to come out of the application.
	        thread.interrupt();
	    }

	    private static class BlockingTask implements Runnable {

	        @Override
	        public void run() {
	            //do things
	        	//while(true) {
	        		try {
		            	
		                Thread.sleep(500000);
		            } catch (InterruptedException e) {
		                System.out.println("Existing blocking thread");
		                //return;
		            }
	        	//}
	            
	        }
	    }
}
