package com.tutorial.termination;

import java.math.BigInteger;

public class Main2 {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new LongComputationTask(new BigInteger("10"), new BigInteger("1000")));
        //Thread thread = new Thread(new LongComputationTask(new BigInteger("200000"), new BigInteger("100000000")));

        thread.start();
        //we are waiting for some 100 seconds to complete the operations.
        Thread.sleep(100);
        thread.interrupt();
    }

    private static class LongComputationTask implements Runnable {
        private BigInteger base;
        private BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(base + "^" + power + " = " + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;

            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
               //adding if statement in each statement and checking whether current thread is interrupted or not.
            	
            	if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Prematurely interrupted computation");
                    return BigInteger.ZERO;// here we are manually returning from the method(application)
                }
                result = result.multiply(base);
            }

            return result;
        }
    }
}
