package com.tutorial.join;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UsingExecutorService {
	
	public static void main(String[] args) {
		List<Long> inputNumbers = Arrays.asList(1500L, 345L, 355L, 224L, 56L, 23L, 56L);
		List<Future<BigInteger>> resultList = new ArrayList<>();
		ExecutorService es = Executors.newCachedThreadPool();
		for(Long lon:inputNumbers) {
			Future<BigInteger> value = es.submit(new FactorialThread(lon));
			resultList.add(value);
		}
		   
		for(Future<BigInteger> future : resultList)
		  {
	            try 
	            {
	                System.out.println("Future result is - " + " - " + future.get() + "; And Task done is " + future.isDone());
	            } 
	            catch (Exception e) 
	            {
	                e.printStackTrace();
	            }		
		  }
	            es.shutdown();      
	}

	public static class FactorialThread implements Callable<BigInteger> {
        private long inputNumber;
        private BigInteger result = BigInteger.ZERO;
        private boolean isFinished = false;
        
        public FactorialThread(long inputNumber) {
            this.inputNumber = inputNumber;
        }

        @Override
        public BigInteger call() {
            this.result = factorial(inputNumber);
            this.isFinished = true;
            return this.result;
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
