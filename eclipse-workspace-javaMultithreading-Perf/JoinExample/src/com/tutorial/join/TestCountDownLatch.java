package com.tutorial.join;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {
	final int NUM_JOBS = 3;
    final CountDownLatch countDownLatch = new CountDownLatch(NUM_JOBS);
    final Object mutex = new Object(); 
    int workData = 0;

    public static void main(String[] args) throws Exception {
    	TestCountDownLatch workerTest = new TestCountDownLatch();
        workerTest.go();
        workerTest.awaitAndReportData();
    }

    private void go() {
        for (int i = 0; i < NUM_JOBS; i++) {
            final int fI = i;
            Thread t = new Thread() {
                public void run() {
                    synchronized(mutex) {
                        workData++;
                    }
                    try {
                        Thread.sleep(fI * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                }
            };
            t.start();
        }
    }

    private void awaitAndReportData() throws InterruptedException {
        countDownLatch.await();
        System.out.println("Waiting for all child threads.....");
        synchronized(mutex) {
            System.out.println("All workers done. workData=" + workData);
        }
    }
}
