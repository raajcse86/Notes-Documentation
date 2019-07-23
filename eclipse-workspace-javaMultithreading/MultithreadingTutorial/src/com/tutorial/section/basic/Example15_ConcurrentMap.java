package com.tutorial.section.basic;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class FirstWorkerMap implements Runnable{
	
	ConcurrentMap<String,Integer> concurrentMap;
	
	public FirstWorkerMap(ConcurrentMap<String,Integer> map) {
		this.concurrentMap = map;
	}
	
	@Override
	public void run() {
		while(true){
			try {
				concurrentMap.put("A", 1);
				concurrentMap.put("B", 2);
				Thread.sleep(1000);
				concurrentMap.put("C", 3);
				concurrentMap.put("D", 4);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}

class SecondWorkerMap implements Runnable{
	
	ConcurrentMap<String,Integer> concurrentMap;
	
	public SecondWorkerMap(ConcurrentMap<String,Integer> map) {
		this.concurrentMap = map;
	}
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(5000);
				System.out.println(concurrentMap.get("A"));
				System.out.println(concurrentMap.get("B"));
				Thread.sleep(1000);
				System.out.println(concurrentMap.get("C"));
				System.out.println(concurrentMap.get("D"));
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}


public class Example15_ConcurrentMap {
	
	public static void main(String[] args) {
		ConcurrentMap<String,Integer> map = new ConcurrentHashMap<>();
		
		new Thread(new FirstWorkerMap(map)).start();
		
		new Thread(new SecondWorkerMap(map)).start();
	}

}
