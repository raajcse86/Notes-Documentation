package com.tutorial.deadlock;

import java.util.Random;

public class DeadLockExample {

	public static void main(String[] args) {
		Intersection intersection = new Intersection();
		Thread t1 = new Thread(new TrainA(intersection));
		Thread t2 = new Thread(new TrainB(intersection));
		t1.start();
		t2.start();
	}
	
public static class TrainA implements Runnable{
	private Intersection intersection;
	private Random random = new Random();
	
	TrainA(Intersection intersection){
		this.intersection = intersection;
	}
	
	
	@Override
	public void run() {
		while(true) {
			long sleeptime = random.nextInt(5);
			try {
				Thread.sleep(sleeptime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			intersection.takeRoadA(); 
			
		}
		
	}
}	

public static class TrainB implements Runnable{
	private Intersection intersection;
	private Random random = new Random();
	
	TrainB(Intersection intersection){
		this.intersection = intersection;
	}
	
	
	@Override
	public void run() {
		while(true) {
			long sleeptime = random.nextInt(5);
			try {
				Thread.sleep(sleeptime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			intersection.takeRoadB(); 
			
		}
		
	}
}
	
public static class Intersection{
	private Object roadA = new Object();
	private Object roadB = new Object();
	
	public void takeRoadA() {
		synchronized (roadA) {
			System.out.println("Road A is locked by thread "+Thread.currentThread().getName());
			synchronized (roadB) {
				try {
					System.out.println("Train is passing through Road A..");
					Thread.sleep(100);
				}catch(InterruptedException e) {
					
				}
			}
		}
		
		
	}
	
	public void takeRoadB() {
		synchronized (roadA) {
			System.out.println("Road B is locked by thread "+Thread.currentThread().getName());
			synchronized (roadB) {
				try {
					System.out.println("Train is passing through Road B...");
					Thread.sleep(100);
				}catch(InterruptedException e) {
					
				}
			}
		}
		
		
	}
	
}	
	
}
