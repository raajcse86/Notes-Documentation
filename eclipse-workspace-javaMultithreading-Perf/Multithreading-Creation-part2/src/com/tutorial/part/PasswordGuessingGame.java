package com.tutorial.part;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PasswordGuessingGame {
	public static final int MAX_PASSWORD = 9999;

    public static void main(String[] args) {
        Random random = new Random();

        int guessPassword = random.nextInt(MAX_PASSWORD);
        System.out.println("Orginal password is "+guessPassword);
        Vault vault = new Vault(guessPassword);

        List<Thread> threads = new ArrayList<>();

        Thread policeThread = new PoliceThread();
        threads.add(new AscendingHackerThread(vault));
        threads.add(new DescendingHackerThread(vault));
        threads.add(policeThread);

        for (Thread thread : threads) {
            thread.start();
        }
        try {
			policeThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private static class Vault {
        private int password;

        public Vault(int password) {
            this.password = password;
        }

        //in case if other thread guessed it correctly - it will return true
        public synchronized boolean  isCorrectPassword(int guess) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
            }
            return this.password == guess;
        }
    }

    private static abstract class HackerThread extends Thread {
        protected Vault vault;

        public HackerThread(Vault vault) {
            this.vault = vault;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(Thread.MAX_PRIORITY);
        }

        @Override
        public void start() {
            System.out.println("Starting thread " + this.getName());
            super.start();
        }
    }

    //first concrete class - it is going to guess the password by iterating through in ascending order
    private static class AscendingHackerThread extends HackerThread {

    	Random random = new Random();
        public AscendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for (int guess = 0; guess < MAX_PASSWORD; guess++) {
            	  int guessPassword = random.nextInt(MAX_PASSWORD);
            	System.out.println("Ascending Thread guessing password....."+guessPassword);
                if (vault.isCorrectPassword(guessPassword)) {
                    System.out.println(this.getName() + " guessed the password " + guess);
                    System.exit(0);
                }
            }
        }
    }

    
    //second concrete class it iterates in descending order.
    private static class DescendingHackerThread extends HackerThread {

    	Random random = new Random();
        public DescendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for (int guess = MAX_PASSWORD; guess >= 0; guess--) {
            	int guessPassword = random.nextInt(MAX_PASSWORD);
            	System.out.println("Descending Thread guessing password...."+guessPassword);
                if (vault.isCorrectPassword(guessPassword)) {
                    System.out.println(this.getName() + " guessed the password " + guess);
                    System.exit(0);
                }
            }
        }
    }

    //it prints the seconds that are left to hackers
    private static class PoliceThread extends Thread {
        @Override
        public void run() {
            for (int i = 10; i > 0; i--) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                System.out.println("PolicThread Count "+i);
            }

            System.out.println("Game over for you hackers");
            System.exit(0);
        }
    }
}
