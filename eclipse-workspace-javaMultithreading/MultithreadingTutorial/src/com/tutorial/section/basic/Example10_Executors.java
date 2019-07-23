package com.tutorial.section.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class Example10_Executors {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		for(int i=0;i<5;i++) {
			executorService.submit(()-> {
				for(int j=0;j<10;j++) {
					System.out.println(j);
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}

	}

}
