package com.tutorial.section.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class WorkerProcessor implements Callable<String>{
	
	private int id;
	
	public WorkerProcessor(int id) {
		this.id = id;
	}
	
	@Override
	public String call() throws Exception {
		return this.id+"";
	}
}


public class Example11_Callable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		List<Future<String>> list = new ArrayList<>();
		for(int i=0;i<5;i++) {
			list.add(executorService.submit(new WorkerProcessor(i)));
		}
		for(Future<String> future:list) {
			System.out.println(future.get());
		}
		
		
		executorService.shutdown();

	}

}
