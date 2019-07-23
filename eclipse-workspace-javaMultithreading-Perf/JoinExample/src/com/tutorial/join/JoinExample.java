package com.tutorial.join;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JoinExample {
	public static void main(String[] args) throws InterruptedException {
        List<Long> inputNumbers = Arrays.asList(2000L, 345L, 355L, 224L, 56L, 23L, 56L);
        CountDownLatch countDownLatch = new CountDownLatch(inputNumbers.size());
        List<FactorialThread> threads = new ArrayList<>();
        
        
        for (long inputNumber : inputNumbers) {
            threads.add(new FactorialThread(inputNumber,countDownLatch));
        }

        for (Thread thread : threads) {
           //thread.setDaemon(true);
            thread.start();
        }

//        for (Thread thread : threads) {
//            thread.join(10000);
//        }

        countDownLatch.await();
        
        for (int i = 0; i < inputNumbers.size(); i++) {
            FactorialThread factorialThread = threads.get(i);
            if (factorialThread.isFinished()) {
                System.out.println("Factorial of " + inputNumbers.get(i) + " is " + factorialThread.getResult());
            } else {
                System.out.println("The calculation for " + inputNumbers.get(i) + " is still in progress");
            }
        }
    }

    public static class FactorialThread extends Thread {
        private long inputNumber;
        private BigInteger result = BigInteger.ZERO;
        private boolean isFinished = false;
        private CountDownLatch countDownLatch;
        
        public FactorialThread(long inputNumber,CountDownLatch countDownLatch) {
            this.inputNumber = inputNumber;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            this.result = factorial(inputNumber);
            this.isFinished = true;
//            try {
//				Thread.sleep(10000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
            countDownLatch.countDown();
        }

        public BigInteger factorial(long n) {
            BigInteger tempResult = BigInteger.ONE;

            for (long i = n; i > 0; i--) {
                tempResult = tempResult.multiply(new BigInteger((Long.toString(i))));
            }
            return tempResult;
        }

        public BigInteger getResult() {
            return result;
        }

        public boolean isFinished() {
            return isFinished;
        }
    }
}
