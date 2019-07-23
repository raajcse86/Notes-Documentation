package com.tutorial.section.basic;

import java.util.ArrayList;
import java.util.List;

//As both the methods are locking on object level, t1 starts produce, t2 starts consume
//as both producer and consumer are in a loop,even after notify it is not going to other thread,
//it waits for list to full in the producer and it goes to wait state.
//similarly the consumer gets empty and then carries on.
//as always statement next to notify will be running, it does not give the control to the other
//immediately.
class ProcessorProducerConsumer {

	List<Integer> list = new ArrayList<>();
	private final int LIMIT = 5;
	private final int BOTTOM = 0;
	private Object lock = new Object();
	private int value = 0;

	public void produce() throws InterruptedException {
		synchronized (lock) {
			while (true) {
				if (list.size() == LIMIT) {
					System.out.println("Waiting for removing the item from the list");
					lock.wait();
				} else {
					System.out.println("Adding ... "+value);
					list.add(value);
					value++;
					lock.notify();
				}
			}
		}
	}

	public void consume() throws InterruptedException {
		synchronized (lock) {
			while (true) {
				if (list.size() == BOTTOM) {
					System.out.println("List is empty.. Waiting for producer to produce");
					lock.wait();
				} else {
					System.out.println("Removing ... "+list.remove(--value));
					lock.notify();
				}
			}
		}
	}
}
public class Example6_ProducerConsumer {

	public static void main(String[] args) throws InterruptedException {
		ProcessorProducerConsumer processor = new ProcessorProducerConsumer();

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					processor.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					processor.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();
	}

}
