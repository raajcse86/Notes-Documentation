package com.tutorial.section.basic;

import java.util.concurrent.Exchanger;

class FirstExchanger implements Runnable{
	
	private int counter = 100;
	Exchanger<Integer> exchanger;
	
	public FirstExchanger(Exchanger<Integer> exchanger) {
		this.exchanger = exchanger;
	}
	
	@Override
	public void run() {
		while(true){
			try {
				counter = counter +1;
				System.out.println("First Thread increment the counter "+counter);
				counter = exchanger.exchange(counter);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}

class SecondExchanger implements Runnable{
	
	private int counter=300;
	Exchanger<Integer> exchanger;
	
	public SecondExchanger(Exchanger<Integer> exchanger) {
		this.exchanger = exchanger;
	}
	
	@Override
	public void run() {
		while(true){
			try {
				counter = counter-1;
				System.out.println("Second Thread decrement the counter "+counter);
				counter = exchanger.exchange(counter);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}


public class Example16_Exchanger {
	
	public static void main(String[] args) {
		Exchanger<Integer> exchanger = new Exchanger<>();
		
		new Thread(new FirstExchanger(exchanger)).start();
		
		new Thread(new SecondExchanger(exchanger)).start();
	}

}
